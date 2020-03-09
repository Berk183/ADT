public class MyBag<AnyType extends Comparable<AnyType>> {
    MyTree theTree;
    
    public MyBag(){
        theTree=new MyTree();
    }
    
    public void addItem(AnyType item){
        theTree.insertNewItem(item);
    }
    public void clear(){
        theTree.clearTree();
    }
    public boolean contains(AnyType item){
        if(theTree.search(item)){
            return true;
        }
        else 
            return false;
    }
    public int distictSize(){
        return theTree.howManyDifferentElements();
    }
    public int elementSize(AnyType item){
        return theTree.howManyItems(item);
    }
    public boolean isEmpty(){
        return theTree.isEmpty();
    }
    public void remove(AnyType item){
        theTree.removeItem(item);
    }
    public int size(){
        return theTree.howManyElements();
    }
    @Override
    public String toString(){
       return theTree.theString();
    }
    @Override
    public boolean equals(Object obj){
        
        if(this.size()==((MyBag)obj).size()){
            if(this.distictSize()==((MyBag)obj).distictSize()){
                if(this.toString().equals(obj.toString())){
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }
    
}
