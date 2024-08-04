public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

    public boolean remover(int valor){
        //buscar o elemento na árvore
        No atual = this.raiz;
        No pai = null;
        while(atual != null){
            if (atual.getValor() == valor){
                break;
            }else if (valor < atual.getValor()) {
                pai = atual;
                atual = atual.getEsq();
            }else { //valor procurado é maior que o atual
                pai = atual;
                atual = atual.getDir();
            }
        }
        //verifica se existe o elemento
        if (atual != null) {

            //elemento tem 2 filhos ou elemento tem somente filho à direita
            if (atual.getDir() != null){

                No substituto = atual.getDir();
                No paiSubstituto = atual;
                while(substituto.getEsq() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsq();
                }
                substituto.setEsq(atual.getEsq());
                if (pai != null){
                    if (atual.getValor() < pai.getValor()) {
                        pai.setEsq(substituto);
                    }else { //atual > pai
                        pai.setDir(substituto);
                    }
                }else { //é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setEsq(null);
                    this.raiz.setDir(paiSubstituto);
                    this.raiz.setEsq(atual.getEsq());
                }

                //remove o elemento da árvore
                if (substituto.getValor() < paiSubstituto.getValor()) {
                    paiSubstituto.setEsq(null);
                }else { //substituto > paiSubstituto
                    paiSubstituto.setDir(null);
                }

            //elemento tem filho só à esquerda
            }else if (atual.getEsq() != null) {
                No substituto = atual.getEsq();
                No paiSubstituto = atual;
                while(substituto.getDir() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDir();
                }
                if (pai != null){
                    if (atual.getValor() < pai.getValor()) {
                        pai.setEsq(substituto);
                    }else{ //atual > pai
                        pai.setDir(substituto);
                    }
                }else { //é a raiz
                    this.raiz = substituto;
                }

                //remove o elemento da árvore
                if (substituto.getValor() < paiSubstituto.getValor()) {
                    paiSubstituto.setEsq(null);
                }else { //substituto > paiSubstituto
                    paiSubstituto.setDir(null);
                }
            }else { //elemento não tem filhos
                if (pai != null){
                    if (atual.getValor() < pai.getValor()){
                        pai.setEsq(null);
                    }else { //atual > pai
                        pai.setDir(null);
                    }
                }else{ //é a raiz
                    this.raiz = null;
                }
            }

            return true;
        }else {
            return false;
        }
    }
}