import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;

class BinaryTreeNode<T>{
    T data;
    int height;
    BinaryTreeNode<T> leftSon;
    BinaryTreeNode<T> rightSon;

    public BinaryTreeNode(T data){
        this.data = data;
        this.height = 0;
        this.leftSon = null;
        this.rightSon = null;
    }
}


class BinaryTree<T extends Comparable<? super T>>{
    private BinaryTreeNode<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void makeEmpy(){
        this.root = null;
    }

    public boolean isEmpy(){
        return this.root == null;
    }
    
    public void preorder(){
        this.auxPreorder(this.root);
    }

    private void auxPreorder(BinaryTreeNode<T> auxRoot){
        if(auxRoot != null){
            System.out.print(auxRoot.data + " ");
            this.auxPreorder(auxRoot.leftSon);
            this.auxPreorder(auxRoot.rightSon);
        }
    }

    public void posorden(){
        this.auxPosorden(this.root);
    }

    private void auxPosorden(BinaryTreeNode<T> auxRoot){
        if(auxRoot != null){
            this.auxPosorden(auxRoot.leftSon);
            this.auxPosorden(auxRoot.rightSon);
            System.out.print(auxRoot.data + " ");
        }
    }

    public void inorder (){
        this.auxInorder(this.root);
    }

    private void auxInorder(BinaryTreeNode<T> auxRoot){
        if(auxRoot != null){
            this.auxInorder(auxRoot.leftSon);
            System.out.print(auxRoot.data + " ");
            this.auxInorder(auxRoot.rightSon);
        }
    }

    public void orderLevel(){
        this.auxOrderLevel(this.root);
    }


    private void auxOrderLevel(BinaryTreeNode<T> auxRoot){
        if(auxRoot == null){
            return;
        }

        Queue<BinaryTreeNode> cola = new LinkedList();

        cola.add(auxRoot);
        cola.add(null);

        while(!cola.isEmpty()){
            BinaryTreeNode curr = cola.poll();
            if(curr == null){
                if(!cola.isEmpty()){
                    cola.add(null);
                }
            }else{
                if(curr.leftSon != null){
                    cola.add(curr.leftSon);
                }
                if(curr.rightSon != null){
                    cola.add(curr.rightSon);
                }
                System.out.print(curr.data + " ");
            }
        }
    }

    public void insert(T newData){
        this.root = this.insert(newData, this.root);
        if(Math.abs(this.height(this.root.leftSon) - this.height(this.root.rightSon)) > 1){

        }
    }

    private BinaryTreeNode<T> insert(T newData, BinaryTreeNode<T> aux){
        if(aux == null){
            return new BinaryTreeNode<>(newData);
        }
        int compareResult = newData.compareTo(aux.data);
        if(compareResult < 0){
            aux.leftSon = insert(newData, aux.leftSon);
        }else if(compareResult > 0){
            aux.rightSon = insert(newData, aux.rightSon);
        }else{
            throw new RuntimeException("Informacion duplicada");
        }
        return rebalancear(aux);
    }

    public boolean  contains(T data){
        return this.contains(data, this.root);
    }

    private boolean contains(T x, BinaryTreeNode<T> aux){
        if(aux == null){
            return false;
        }

        int compareResult = x.compareTo(aux.data);
        if(compareResult < 0){
            return contains(x, aux.leftSon);
        }else if(compareResult > 0){
            return contains(x, aux.rightSon);
        }else{
            return true;
        }
    }

    public T findMin (){
        return this.findMin(this.root);
    }

    private T findMin(BinaryTreeNode<T> aux){
        if(aux == null){
            return null;
        }
        if(aux.leftSon == null){
            return aux.data;
        }
        return findMin(aux.leftSon);
    }

    public T findMax(){
        return this.findMax(this.root);
    }

    private T findMax(BinaryTreeNode<T> aux){
        if(aux == null){
            return null;
        }
        if(aux.rightSon == null){
            return aux.data;
        }
        return findMax(aux.rightSon);
    }

    public void remove(T toDelete){
        this.root = this.remove(toDelete, this.root);
        if(Math.abs(this.height(this.root.leftSon) - this.height(this.root.rightSon)) > 1){
            
        }
    }

    private BinaryTreeNode<T> remove(T toDelete, BinaryTreeNode<T> aux){
        if(aux == null){
            return aux;
        }else{
            aux = rebalancear(aux);
        }
        int compareResult = toDelete.compareTo(aux.data);
        if(compareResult < 0 ){
            aux.leftSon = this.remove(toDelete, aux.leftSon);
        }else if(compareResult > 0){
            aux.rightSon = this.remove(toDelete, aux.rightSon);
        }else if(aux.leftSon != null && aux.rightSon != null){
            T sucesor = this.findMin(aux.rightSon) ;
            aux.data = sucesor;
            aux.rightSon = remove(sucesor, aux.rightSon);
        }else{
            aux = (aux.leftSon != null) ? aux.leftSon : aux.rightSon; 
        }
        return aux;
    }

    public int height(){
        return this.height(this.root);
    }

    private int height(BinaryTreeNode<T> t){
        if(t == null){
            return -1;
        }else{
            return 1 + Math.max(this.height(t.leftSon), this.height(t.rightSon));
        }
    }

    private int balancear(BinaryTreeNode<T> n){
        return (n == null) ? 0 :  height(n.rightSon) - height(n.leftSon);
    }

    private BinaryTreeNode rebalancear(BinaryTreeNode aux){
        int b = balancear(aux);
        if(b > 1){
            if(height(aux.rightSon.rightSon) > height(aux.rightSon.leftSon)){
                aux = leftRotation(aux);
            }else{ 
                aux.rightSon = rightRotation(aux.rightSon);
                aux = leftRotation(aux);
            }
        }else if(b < -1){
            if(height(aux.leftSon.leftSon) > height(aux.leftSon.rightSon)){
                aux = rightRotation(aux);
            }else{
                aux.leftSon = leftRotation(aux.leftSon);
                aux = rightRotation(aux);
            }
        }
        return aux;
    }

    private BinaryTreeNode rightRotation(BinaryTreeNode<T> aux){
        BinaryTreeNode temp = aux.leftSon;
        aux.leftSon = temp.rightSon;
        temp.rightSon = aux;
        height(aux);
        height(temp);
        return temp;
    }
    private BinaryTreeNode leftRotation(BinaryTreeNode<T> aux){
        BinaryTreeNode temp = aux.rightSon;
        aux.rightSon = temp.leftSon;
        temp.leftSon = aux;
        height(aux);
        height(temp);
        return temp;
    }
}


public class TreeTravesal {
    public static void main(String[] args){
        BinaryTree<Integer> modulo = new BinaryTree<>();
        
        modulo.insert(1);
        modulo.insert(2);
        modulo.insert(3);
        modulo.insert(4);
        modulo.insert(5);
        modulo.insert(6);
        modulo.insert(7);
        modulo.insert(8);
        modulo.insert(9);
        modulo.insert(10);
        modulo.insert(11);
        modulo.insert(12);

        modulo.preorder();
        System.out.println();
        modulo.posorden();
        System.out.println();
        modulo.inorder();
        System.out.println();
        modulo.orderLevel();
        System.out.println();

        System.out.println(modulo.contains(2));
        System.out.println(modulo.findMax());
        System.out.println(modulo.findMin());

        modulo.remove(2);
        System.out.println(modulo.contains(2));
        modulo.preorder();
        System.out.println();
        modulo.posorden();
        System.out.println();
        modulo.inorder();
        System.out.println();
        modulo.orderLevel();
        System.out.println();
        System.out.println(modulo.height());
    }
}
