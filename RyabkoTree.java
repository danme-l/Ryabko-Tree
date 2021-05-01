package comp2402a4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class RyabkoTree implements PrefixStack {
  int stack[];    // the ints that we've added to the stack
  long tree[];    // the tree data structure
  int currInd;

  public RyabkoTree() {
    stack = new int[17];
    tree = new long[18];
    currInd = 0;
  }

  public void push(int x){
    if(currInd == stack.length){ 
      int temp1[] = new int[2*currInd];             //doubles the size of the stack
      
      System.arraycopy(stack, 0, temp1, 0, currInd);  //copies into a new array
      stack = temp1;

      tree = rebuildTree(stack);  //this is the problem - everything works until I have to call rebuildTree.
    }

    stack[currInd] = x;
    updateTree(x, currInd+1);

    currInd++;
  }

  public int pop(){
    int popVal = stack[currInd-1];
    stack[currInd-1] = 0;
    if(currInd>0)
      currInd--;
    
    updateTree((0-popVal), currInd+1);

    return popVal;
  }
  
  public int get(int i){
    return stack[i];
  }
  public int set(int i, int x){
    int retValue = stack[i];
    stack[i] = x;

    updateTree((x-retValue), i+1);
    
    return retValue;
  }

  public int size(){
    return currInd;
  }

  public Iterator<Integer> iterator() {
    Iterator<Integer> it = new Iterator<Integer>() {
      private int itIndex = 0;

      public boolean hasNext() {
        return itIndex < currInd;
      }

      public Integer next(){
        return stack[itIndex++];
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }
    };    
    return it;
  }

  public void updateTree(int val, int index){ 
    while(index < tree.length){         // checks if the current index is still within the tree's length
        tree[index] += (long) val;      // adds the value at the index
        index = getNext(index);       // needs to update the next index to make sure every relevant node holds the correct sum
    }
  }

  public long[] rebuildTree(int input[]){
    long newTree[] = new long[input.length+1];
    for(int i=1; i <= input.length; i++){                                //goes through every entry in the input array
        updateTree(newTree, input[i-1], i);       //calls update on tree array, for the working index
    }
    return newTree;
  }
  
  public void updateTree(long inputTree[], int val, int index){ 
    while(index < inputTree.length){ // checks if the current index is still within the tree's length
        inputTree[index] += val;     // adds the value at the index
        index = getNext(index);              // needs to update the next index to make sure every relevant node holds the correct sum
    }
}
  
  public long prefixSum(int index){
      index = index + 1;
      long sum = 0;
      while(index > 0){
          sum += tree[index];
          index = getParent(index);
      }
      return sum;
  }

  private int getParent(int index){
      return index - (index & -index);
  }
  private int getNext(int index){
      return index + (index & -index);
  }

  public void display(){
    System.out.print("stack: [");
    for (int i=0; i<stack.length; i++){
      System.out.print(stack[i] + ", ");
    }
    System.out.println("]");

    System.out.print(" tree: [");
    for (int i=0; i<tree.length; i++){
      System.out.print(tree[i] + ", ");
    }
    System.out.println("]");
  }
   
}

