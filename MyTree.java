public class MyTree<AnyType extends Comparable<AnyType>> {
    private Node<AnyType> root;
    private AnyType nodeData;
    private boolean searchCondition;
    private Node<AnyType> temp;
    private int elementsNumber;
    private int differentElementsNumber;
    private String theString;
    
    
    public boolean isEmpty(){
        if(root==null){
            return true;
        }
        else
            return false;  
    }
    
    public void insertNewItem(AnyType Data){
        Node <AnyType> newItem=new Node<>(null,Data,null,null);
        if(isEmpty()){
            root=newItem;
        }
        else{
            Node <AnyType> currentNode;
            currentNode=root;
            while(true){
            if(currentNode.getData().compareTo(newItem.getData())<0){
                if(currentNode.getRight()==null){
                    currentNode.setRight(newItem);
                    newItem.setParent(currentNode);
                    break;
                }
                else{
                    currentNode=currentNode.getRight();
                }
               
            }
            else if(currentNode.getData().compareTo(newItem.getData())>0){
                if(currentNode.getLeft()==null){
                    currentNode.setLeft(newItem);
                    newItem.setParent(currentNode);
                    break;
                }
                else{
                    currentNode=currentNode.getLeft();
                }
            }
            else{
                currentNode.increaseCounter();
                break;
            }
            
          }
        }
    }
    public void printTree(){
        if(isEmpty())
        System.out.println("There is no item stored");
        
        else
        printTree(root);
            
        }
    private void printTree(Node<AnyType> tempNode){
        if(tempNode == null){
            return;
        }
        else{
            printTree(tempNode.getLeft());
            System.out.println(tempNode.getData() + " ");
            printTree(tempNode.getRight());
        }
            
    }
    public void removeItem(AnyType Data){
        nodeData=Data;
        traverseForDeletion(root);
        if(search(Data)){
            if(temp.getCounter()>1){
               temp.decreaseCounter();
            }
            else
        removeItem(temp);
        
        }
        else
            System.out.println("Number is not valid");
        temp=null;
    }
    private void removeItem(Node<AnyType> tempNode){
        
            
            if(tempNode.getLeft()!=null && tempNode.getRight()==null || tempNode.getLeft()!=null && tempNode.getRight()!=null){//for node that right side is empty and left side is filled
                Node<AnyType> newNode=greatestOfLeft(tempNode);
                
                if(newNode.getLeft()!=null){//to check newNode is a leaf or not
                    if(newNode.getParent().getData().compareTo(tempNode.getData())!=0){//if newNodes(biggest of the left or smallest of the right) parent is tempNode(node which will be deleted) then there will be a problem with pointers 
                    newNode.getLeft().setParent(newNode.getParent());
                    newNode.getParent().setRight(newNode.getLeft());
                    }
                    newNode.setParent(tempNode.getParent());
                    
                    
                    if(tempNode.getParent()!=null && newNode.getParent().getData().compareTo(tempNode.getData())!=0){//if newNodes(biggest of the left or smallest of the right) parent is tempNode(node which will be deleted) then there will be a problem with pointers 
                    newNode.setLeft(tempNode.getLeft());
                    newNode.setRight(tempNode.getRight());
                    }
                     if(tempNode.getParent()==null){//if the temp node is root node and at the same time  newnodes parent 
                        
                        newNode.setRight(tempNode.getRight());
                        
                    }
                    
                     if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())>0){//if there is a node bigger than the smallest without this if structure wont work well
                        tempNode.getParent().setRight(newNode);
                    }
                    else if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())<0)
                    tempNode.getParent().setLeft(newNode);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                    if(newNode.getParent()==null){
                    root=newNode;
                    }
                    nodeData=null;
                    
                }
                else{
                    if(newNode.getParent().getData().compareTo(tempNode.getData())!=0){
                    newNode.getParent().setRight(null);
                    newNode.setLeft(tempNode.getLeft());
                    }
                    newNode.setParent(tempNode.getParent());
                    newNode.setRight(tempNode.getRight());
                    
                     if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())>0){
                        tempNode.getParent().setRight(newNode);
                    }
                    else if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())<0)
                    tempNode.getParent().setLeft(newNode);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                    if(newNode.getParent()==null){
                    root=newNode;
                    }
                    nodeData=null;
                    
                }
            }
            else if(tempNode.getRight()!=null && tempNode.getLeft()==null){//for node that left side is empty and right side is filled
                Node<AnyType> newNode = smallestOfRight(tempNode);
                
                if(newNode.getRight()!=null){//to check newNode is a leaf or not
                    
                    if(newNode.getParent().getData().compareTo(tempNode.getData())!=0){//if newNodes(biggest of the left or smallest of the right) parent is tempNode(node which will be deleted) then there will be a problem with pointers  
                        newNode.getRight().setParent(newNode.getParent());
                        newNode.getParent().setLeft(newNode.getRight());
                    }
                    
                    newNode.setParent(tempNode.getParent());
                    
                    if(tempNode.getParent()!=null && newNode.getParent().getData().compareTo(tempNode.getData())!=0){//if newNodes(biggest of the left or smallest of the right) parent is tempNode(node which will be deleted) then there will be a problem with pointers 
                    newNode.setRight(tempNode.getRight());
                    newNode.setLeft(tempNode.getLeft());
                    }
                    if(tempNode.getParent()==null){//if the temp node is root node and at the same time  newnodes parent 
                        
                        newNode.setLeft(tempNode.getLeft());
                    }
                    
                    
                     if(tempNode.getParent()!=null &&tempNode.getData().compareTo(tempNode.getParent().getData())>0){//if there is a node bigger than the smallest without this if structure wont work well
                        tempNode.getParent().setRight(newNode);
                    }
                     
                    else if(tempNode.getParent()!=null &&tempNode.getData().compareTo(tempNode.getParent().getData())<0)
                    tempNode.getParent().setLeft(newNode);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                    if(newNode.getParent()==null){
                    root=newNode;
                    }
                    nodeData=null;
                }
                else{
                    if(newNode.getParent().getData().compareTo(tempNode.getData())!=0){
                    newNode.getParent().setLeft(null);
                    newNode.setRight(tempNode.getRight());
                    }
                    newNode.setParent(tempNode.getParent());
                    
                    newNode.setLeft(tempNode.getLeft());
                     if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())>0){
                        tempNode.getParent().setRight(newNode);
                    }
                     else if(tempNode.getParent()!=null && tempNode.getData().compareTo(tempNode.getParent().getData())<0)
                    tempNode.getParent().setLeft(newNode);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                    if(newNode.getParent()==null){
                    root=newNode;
                    }
                    nodeData=null;
                }
            }
            else if(tempNode.getLeft()==null && tempNode.getRight()==null){//for node that both sides are empty
                if(tempNode.getParent().getData().compareTo(tempNode.getData())>0){
                    tempNode.getParent().setLeft(null);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                }
                else{
                    tempNode.getParent().setRight(null);
                    tempNode.setRight(null);
                    tempNode.setLeft(null);
                    tempNode.setParent(null);
                }     
            }    
        }     
    
    
    private Node<AnyType> smallestOfRight(Node<AnyType> junkNode){
    Node<AnyType> smallest; 
    smallest=junkNode.getRight();
        while(smallest.getLeft()!=null){
            smallest=smallest.getLeft();
        }
        return smallest;
        
} 
    private Node<AnyType> greatestOfLeft(Node<AnyType> junkNode){
        Node<AnyType>greatest;
        greatest=junkNode.getLeft();
        while(greatest.getRight()!=null){
            greatest=greatest.getRight();
        }
        return greatest;
    }
    
    public void clearTree(){
        root=null;
    }
    public boolean search(AnyType Data){
        nodeData=Data;
        traverseForSearch(root);
        if(searchCondition==true){
            nodeData=null;
            searchCondition=false;
            return true;
        }
        else{
            nodeData=null;
            return false;
        }
        
    }
    
    private void traverseForSearch(Node<AnyType> tempNode){
         if(tempNode == null)
            return;
         if(tempNode.getData().compareTo(nodeData)==0){
             searchCondition=true;
         }
        traverseForSearch(tempNode.getLeft());
        traverseForSearch(tempNode.getRight());
    }
    private void traverseForDeletion(Node<AnyType> tempNode){
         if(tempNode == null)
            return;
         if(tempNode.getData().compareTo(nodeData)==0){
             temp=tempNode;
         }
        traverseForDeletion(tempNode.getLeft());
        traverseForDeletion(tempNode.getRight());
    }
    public int howManyItems(AnyType Data){
        nodeData=Data;
        traverseForDeletion(root);
        return temp.getCounter();     
    }
    private void printTreeWithNumbers(Node<AnyType> tempNode){
        if(tempNode == null){
            return;
        }
        else{
            printTreeWithNumbers(tempNode.getLeft());
            System.out.println(tempNode.getData() + " " +tempNode.getCounter()+" ");
            printTreeWithNumbers(tempNode.getRight());
        }
            
    }
    public void printTreeWithNumbers(){
        if(isEmpty())
        System.out.println("There is no item stored");
        
        else
        printTreeWithNumbers(root);
            
        }
    public int howManyDifferentElements(){
        differentElementsNumber=0;
        howManyElements(root);
        return differentElementsNumber;
    }
    private void howManyElements(Node<AnyType> tempNode){
        if(tempNode == null){
            return;
        }
        else{
            howManyElements(tempNode.getLeft());
            differentElementsNumber++;
            elementsNumber=elementsNumber+tempNode.getCounter();
            
            
            howManyElements(tempNode.getRight());
        }
            
    }
    public int howManyElements(){
        elementsNumber=0;
        howManyElements(root);
        return elementsNumber;
    }
   private void getTheString(Node<AnyType> tempNode){
        if(tempNode == null){
            return;
        }
        else{
            getTheString(tempNode.getLeft());
            theString=theString+(tempNode.getData() + " ----> " +tempNode.getCounter()+" \n");
            getTheString(tempNode.getRight());
        }
   }
   public String theString(){
       theString="";
       getTheString(root);
       return theString;
   }
    
}
