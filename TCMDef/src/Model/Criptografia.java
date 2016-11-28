/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Aluno
 */
public class Criptografia {
    
    
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;
        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public static String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }

    
    /*public void Logar() throws Throwable { //loga os usuarios que são cadastrados no BD
        String username;
        String senha = pwsenha.getText();
        try {

            
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> usuario = new ArrayList<Usuario>((dao.getList()));

            for (int x = 0; x < usuario.size(); x++) {
             MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[]=md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b: messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
            }
        String senhaHex = sb.toString();
                
                if (txlogin.getText().equals(usuario.get(x).getEmail()) && usuario.get(x).getSenha().equals(senhaHex)){
                    PrincipalMain principal = new PrincipalMain();
                    LoginMain.getStage().close();
                    username = (usuario.get(x).getNome() + " " + usuario.get(x).getSobrenome());

                    try {
                        //Informacoes();
                        principal.start(new Stage());
                        Alert login = new Alert(Alert.AlertType.CONFIRMATION);
                        login.setHeaderText("Seja bem vindo(a) " + username);
                        login.show();
                        x = usuario.size();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (x == usuario.size() - 1) {
                    Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Usuario e/ou senha invalidos! "
                            + "Tente novamente");
                    erro.show();
                    pwsenha.clear();
                    txlogin.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    
}
