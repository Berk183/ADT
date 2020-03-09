 public class Node<AnyType> 
{
    private AnyType data;
    private Node<AnyType> right;
    private Node<AnyType> left;
    private Node<AnyType> parent;
    private int counter;
    
    
    public Node(Node<AnyType> left, AnyType data, Node<AnyType> right,Node<AnyType> parent){
        this.left=left;
        this.data=data;
        this.right=right;   
        this.parent=parent;
        counter=1;
                
    }
    public Node(){
        this.left=null;
        this.data=null;
        this.right=null;
        this.parent=null;
        counter=1;
    }
    
    
    public AnyType getData(){
        return data; 
    }
    
    public Node<AnyType> getRight(){ 
        return right;
    }
    public Node<AnyType> getLeft(){
        return left;
    }
  
    public void setData(AnyType newData){ 
        data = newData; 
    }
    
    public void setRight(Node<AnyType> newRight){
        right = newRight; 
    }   
    
    public void setLeft(Node<AnyType> newLeft){
        left = newLeft;
    }
    public Node<AnyType> getParent(){ 
        return parent;
    }
    public void setParent(Node<AnyType> newParent ){
        parent= newParent;
        
    }
     public void increaseCounter(){
         counter++;   
     }
     public void decreaseCounter(){
         counter--;
     }
     public int getCounter(){
         return counter;
     }
    
    
}