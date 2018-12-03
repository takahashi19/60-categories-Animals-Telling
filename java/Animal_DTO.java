public class Animal_DTO {

//フィールド変数１２個
//ユーザーの情報
	private String str60Name;
	private String strDetail;
//恋人情報
	private String strLover_name;
	private String strLover_detail;
	private String strLover_ad;
//友人
	private String strFriend_name;
	private String strFriend_detail;
	private String strFriend_ad;
//仕事
	private String strWork_name;
	private String strWork_detail;
	private String strWork_ad;
//12Id（Resurt画面表示分類用）
	private int int12Id;


//コンストラクタ
	public Animal_DTO (){
	}
//練習コンストラクタ
	public Animal_DTO (String str60Name){
		this.str60Name = str60Name;
	}

//----------------------本番用コンストラクタ---------------------------
//60分類の動物名、詳細、12分類のid、恋人詳細、友達詳細、仕事仲間詳細

	public Animal_DTO (String str60Name,int int12Id, String strDetail,
										 String strLover_detail,String strFriend_detail, String strWork_detail){
	//ユーザーの情報代入
		this.str60Name = str60Name;
		this.int12Id = int12Id;
		this.strDetail = strDetail;
		this.strLover_detail =strLover_detail;
		this.strFriend_detail = strFriend_detail;
		this.strWork_detail = strWork_detail;
	}



//SETメソッド
//恋人
  public void setStrLover_name(String strLover_name){
    this.strLover_name = strLover_name;
  }
  public void setStrLover_ad(String strLover_ad){
    this.strLover_ad = strLover_ad;
  }

//友人
  public void setStrFriend_name(String strFriend_name){
    this.strFriend_name = strFriend_name;
  }
  public void setStrFriend_ad(String strFriend_ad){
    this.strFriend_ad = strFriend_ad;
  }
//仕事仲間

  public void setStrWork_name(String strWork_name){
    this.strWork_name = strWork_name;
  }
  public void setStrWork_ad(String strWork_ad){
    this.strWork_ad = strWork_ad;
  }


//GETメソッド
//ユーザー
  public String getStr60Name(){
    return str60Name;
  }
  public String getStrDetail(){
    return strDetail;
  }
//恋人
  public String getStrLover_name(){
    return strLover_name;
  }
  public String getStrLover_detail(){
    return strLover_detail;
  }
  public String getStrLover_ad(){
    return strLover_ad;
  }

//友人
  public String getStrFriend_name(){
    return strFriend_name;
  }
  public String getStrFriend_detail(){
    return strFriend_detail;
  }
  public String getStrFriend_ad(){
    return strFriend_ad;
  }

//仕事仲間
  public String getStrWork_name(){
    return strWork_name;
  }
  public String getStrWork_detail(){
    return strWork_detail;
  }
  public String getStrWork_ad(){
    return strWork_ad;
  }
//１２分類ID
  public int getInt12Id(){
    return int12Id;
  }
}