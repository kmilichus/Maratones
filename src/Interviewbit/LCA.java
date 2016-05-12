import org.omg.Messaging.SyncScopeHelper;

public class LCA {
	
	 public static class TreeNode  
	 {  
	  static int data;  
	  TreeNode left;  
	  TreeNode right;  
	  TreeNode(int data)  
	  {  
	   this.data=data;  
	  }  
	 }


	public static void main(String[] args) {
		
		TreeNode rootNode =new TreeNode(40);  
		  TreeNode node20=new TreeNode(20);  
		  TreeNode node10=new TreeNode(10);  
		  TreeNode node30=new TreeNode(30);  
		  TreeNode node60=new TreeNode(60);  
		  TreeNode node50=new TreeNode(50);  
		  TreeNode node70=new TreeNode(70); 
		  
		  rootNode.left=node20;  
		  rootNode.right=node60;  
		    
		  node20.left=node10;  
		  node20.right=node30;  
		    
		  node60.left=node50;  
		  node60.right=node70;  
		    

		 System.out.println("El ancestro comun es: "+ LCA(rootNode, new NodoContar(), 10, 50).lca.data);

	}

	
//	public void inOrder(TreeNode root) {  
//		  if(root !=  null) {  
//		   inOrder(root.left);  
//
//		   inOrder(root.right);  
//		  }  
//		 } 

	
//	public int solve (int cantidad){
//		
//		
//		
//	}
//	
	public static NodoContar LCA(TreeNode arbol, NodoContar search, int a, int b){
	
	if (arbol!=null) {
		if (arbol.data == a || arbol.data == b) {
			search.value = search.value +1;
		}
	}
	
	if (arbol.left != null) {
		LCA(arbol.left, search,a,b);
	}
	
	if (arbol.right != null) {
		 LCA(arbol.right, search,a,b);
	}
	
	if (search.value == 2 && search.lca == null) {
		search.lca = arbol;
	}
	
//	 System.out.println(search.value == TreeNode.data +  "valor del tree node "+TreeNode.data);
		
		
	return search;
	}
	
	 public static class NodoContar  { 
		 int value;
	  TreeNode lca;  
	  NodoContar(){
		  value= 0;
		  lca=null;
	  }
	  
	 }


}
