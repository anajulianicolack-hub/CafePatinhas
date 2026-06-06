package interfaces;

public interface Adotavel {

    void realizarAdocao(); /*Quem for adotavel, precisa ter uma lógica para realizar a adoção.
    É aqui onde a NAT vai especificar, no código dela, como um Pet é adotado*/

    boolean isAdotado(); /*precisa devolver um valor booleano dizendo se foi ou não adotado*/

}
