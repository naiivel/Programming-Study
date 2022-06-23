package application;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class signUpController implements Initializable {

	@FXML private Button btn1,btn2,btn3;
	@FXML private TextField textID,textName,textPhone;
	@FXML private PasswordField textPW,textPWC;
	@FXML private Label IDC,PWC;
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("호출시 자동 실행");
		btn1.setOnAction(e -> IDCCheck());
		btn2.setOnAction(e -> signUp());
		btn3.setOnAction(e -> signUpCancel());
		
		//항목이 전부 입력되기전까지 회원가입버튼 비활성화
		btn2.setDisable(true);
		
		//비밀번호, 비밀번호 확인 실시간 검사
				textPWC.textProperty().addListener(e->{
					if(textPW.getText().equals(null)) {
						PWC.setText("PWC");
					} else if(!textPW.getText().equals(textPWC.getText())){
						PWC.setText("비밀번호가 일치하지 않습니다.");
						PWC.setTextFill(Color.RED);
					} else if(textPW.getText().equals(textPWC.getText())) {
						PWC.setText("비밀번호가 일치합니다.");
						PWC.setTextFill(Color.BLUE);
					}
				});
				
		//텍스트 입력창에 함수입력
		textID.textProperty().addListener((attribute, before, after)->{
			idlengthCheck();
			emptyCheck();
		});
		
		textPW.textProperty().addListener((attribute, before, after)->{
			emptyCheck();
			pwlengthCheck();
		});
		
		textPWC.textProperty().addListener((attribute, before, after)->{
			emptyCheck();
			pwlengthCheck();
		});
		
		textName.textProperty().addListener((attribute, before, after)->{
			emptyCheck();
			pwlengthCheck();
		});
				
		textPhone.textProperty().addListener((attribute, before, after)->{
			emptyCheck();
			pwlengthCheck();
		});
		
		btn2.setOnAction(event->{
			buttonClick();
		});
		
	}	


	public void IDCCheck() {
		//IDC 버튼
		/*String id = textID.getText();
		   
		   if(db.getPassword(id) == id) {
			  message("이미 등록된 아이디입니다.");
			  IDC.setText("이미 등록된 아이디입니다.");
			  IDC.setTextFill(Color.RED);
		} else {
		 	  message("사용가능한 아이디입니다.");
		 	  IDC.setText("사용가능한 아이디입니다.");
		 	  IDC.setTextFill(Color.BLUE);
		}
		*/
	}
	
	public void signUp() {
		//Regi confirm 버튼
		/*Class.forName("mysql.jdbc.driver.oracledriver");
		 * Connection conn = DriverManager.getConnection("jdbc:mysql:thin:@localhost:1521:xe","","");
		 * if(conn==null){System.out.println("DB접속실패");}
		 * System.out.println("DB접속성공");
		 * Result rs = null;
		 * String sql = "select * from ~~~~ where no = ?";
		 * PreparedStatement pstmt = conn.prepareStatement(sql);
		 * 
		 */
		//
		
		System.out.println("Regi confirm 선택");
		/*
		if(!textID.getText().equals("db값") && !textPW.getText().equals("db값") {
			회원가입 정보 DB에 저장
		} else { 
			message("이미 사용중인 아이디입니다.");
			textID.requestFocus();
		}
		
		*/
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("../mainPage/mainPage.fxml"));
		} catch (IOException e1) {}
		stage=(Stage)btn2.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
		this.primaryStage.close();
	}
	
	public void signUpCancel() {
		//Regi cancel 버튼
		System.out.println("Back 선택");	
		textID.setText(null);
		textName.setText(null);
		textPhone.setText(null);
		textPW.setText(null);
		textPWC.setText(null);
		textID.requestFocus();
	}	
	
	public void buttonClick() {
		idlengthCheck();
		pwlengthCheck();
		loginCheck();
	}
	
	public void idlengthCheck() {
		if(textID.getLength()>8) {
			String tmp = textID.getText();
			tmp = tmp.substring(0,8);
			textID.setText(tmp);
		}
	}
	
	public void pwlengthCheck() {
		if(textPW.getLength()>10) {
			String tmp = textPW.getText();
			tmp = tmp.substring(0,10);
			textPW.setText(tmp);
		}
	}
	
	public void loginCheck() {
		String id = textID.getText();
		String pw = textPW.getText();
		/* MyDB db = new MyDB();
		 * if(db.getPassword(id) != null && db.getPassword(id).equals(pw)){
		 * 		message("로그인성공");
		 * else {
		 * 		message("로그인실패");
		 * 		textPW.clear();
		 * 		textPW.requestFocus();
		 * 		btn2.setDisable(true);
		 * 		textID.requestFocus();
		 * }
		 */
	}
	
	public void emptyCheck() {
		if(textID.getText().isEmpty() || textPW.getText().isEmpty() || textPWC.getText().isEmpty() || textName.getText().isEmpty() || textPhone.getText().isEmpty()) {
			btn2.setDisable(true);
		} else {
			btn2.setDisable(false);
		}
	}
	
	public void message(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}
	
}
