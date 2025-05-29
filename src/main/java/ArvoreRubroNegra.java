public class ArvoreRubroNegra {
    private No raiz;

    public void inserir(int valor) {
        No novo = new No(valor);
        novo.cor = true;

        raiz = inserirRecursivo(raiz, novo);
        balancearAposInsercao(novo);

        raiz.cor = false;
    }

    private No inserirRecursivo(No atual, No novo) {
        if (atual == null) {
            return novo;
        }

        if (novo.valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, novo);
            atual.esquerda.pai = atual;
        } else if (novo.valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, novo);
            atual.direita.pai = atual;
        }
        return atual;
    }

    private void balancearAposInsercao(No no) {
        while (no != raiz && no.pai.cor) {
            No avo = no.pai.pai;

            if (no.pai == avo.esquerda) {
                No tio = avo.direita;

                if (tio != null && tio.cor) {
                    no.pai.cor = false;
                    tio.cor = false;
                    avo.cor = true;
                    no = avo;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoDireita(avo);
                }
            } else {
                No tio = avo.esquerda;

                if (tio != null && tio.cor) {
                    no.pai.cor = false;
                    tio.cor = false;
                    avo.cor = true;
                    no = avo;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoEsquerda(avo);
                }
            }
        }

        raiz.cor = false;
    }

    private void rotacaoEsquerda(No x) {
        No y = x.direita;
        x.direita = y.esquerda;

        if (y.esquerda != null)
            y.esquerda.pai = x;

        y.pai = x.pai;

        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(No x) {
        No y = x.esquerda;
        x.esquerda = y.direita;

        if (y.direita != null)
            y.direita.pai = x;

        y.pai = x.pai;

        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.direita) {
            x.pai.direita = y;
        } else {
            x.pai.esquerda = y;
        }

        y.direita = x;
        x.pai = y;
    }

    public No getRaiz() {
        return raiz;
    }
}
