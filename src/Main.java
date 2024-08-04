public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(13);
        arvoreBinaria.inserir(20);
        System.out.println("\nEm-Ordem:");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("\nPré-Ordem:");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("\nPós-Ordem:");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        arvoreBinaria.remover(8);
        System.out.println("\n\nAPÓS REMOVER O NÓ:");
        System.out.println("\nEm-Ordem:");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("\nPré-Ordem:");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("\nPós-Ordem:");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
    }
}