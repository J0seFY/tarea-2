import java.util.LinkedList;

public class KdTree {

    KdNode root;

    public KdTree() {
        root = null;
    }

    public void insert(int edad,int peso,float factor){
        root = insertarEnKdTree(root,edad,peso,factor,0);
    }

    private KdNode insertarEnKdTree(KdNode node, int edad, int peso, float factor,int nivel){

        if(node == null){
            return new KdNode(edad,peso,factor);
        }

        int dim = nivel % 2;

        if(dim == 0){
            if(edad < node.edad){
                node.left = insertarEnKdTree(node.left,edad,peso,factor,nivel++);
            }else{
                node.right = insertarEnKdTree(node.right,edad,peso,factor,nivel++);
            }
        }else{
            if(peso < node.peso){
                node.left = insertarEnKdTree(node.left,edad,peso,factor,nivel++);
            }else{
                node.right = insertarEnKdTree(node.right,edad,peso,factor,nivel++);
            }
        }

        return node;

    }

    // problema 1 funcion factor
    public float factor(int edad,int peso){

        KdNode nodo = buscar(root,edad,peso,0);

        float factor = nodo != null? nodo.factor : -1;

        return  factor;
    }

    private KdNode buscar(KdNode node,int edad,int peso,int nivel){
        if(node == null || (node.edad == edad && node.peso == peso )){
            return node;
        }

        int niv = nivel % 2;
        if(niv == 0){
            if(edad < node.edad){
                return buscar(node.left,edad,peso,nivel++);
            }else{
                return buscar(node.right,edad,peso,nivel++);
            }
        }else{
            if(peso < node.peso){
                return buscar(node.left,edad,peso,nivel++);
            }else{
                return buscar(node.right,edad,peso,nivel++);
            }
        }


    }


    public int contarRango(int minE,int maxE,int minP,int maxP,float minF){

        return buscarRango(root,minE,maxE,minP,maxP,minF,0);

    }

    private int buscarRango ( KdNode nodo ,int minE,int maxE,int minP,int maxP,float minF , int nivel) {
        if (nodo == null) {
            return 0 ;
        }

        int niv = nivel % 2;

        if(niv == 0) {
            if (nodo.edad >= minE) {
                buscarRango(nodo.left, minE, maxE, minP, maxP, minF,nivel++);
                return 1 ;
            }

            if (nodo.edad >= minE && nodo.edad <= maxE && nodo.peso >= minP && nodo.peso <= maxP && nodo.factor >= minF) {

            }

            if (nodo.edad <= maxE) {
                buscarRango(nodo.right, minE, maxE, minP, maxP, minF,nivel++);
                return
            }
        }



    }

      */


    private class KdNode{
    
        int edad; // en el kd tree representa a x
        int peso; //en el kd tree representa a y
        float factor;
        KdNode left;
        KdNode right;

        public KdNode() {
        }

        public KdNode(int edad, int peso, float factor) {
            this.edad = edad;
            this.peso = peso;
            this.factor = factor;
        }

        public KdNode(int edad, int peso, float factor, KdNode left, KdNode right) {
            this.edad = edad;
            this.peso = peso;
            this.factor = factor;
            this.left = left;
            this.right = right;
        }
    }
}
