public class Animal_DTO {

//�t�B�[���h�ϐ��P�Q��
//���[�U�[�̏��
	private String str60Name;
	private String strDetail;
//���l���
	private String strLover_name;
	private String strLover_detail;
	private String strLover_ad;
//�F�l
	private String strFriend_name;
	private String strFriend_detail;
	private String strFriend_ad;
//�d��
	private String strWork_name;
	private String strWork_detail;
	private String strWork_ad;
//12Id�iResurt��ʕ\�����ޗp�j
	private int int12Id;


//�R���X�g���N�^
	public Animal_DTO (){
	}
//���K�R���X�g���N�^
	public Animal_DTO (String str60Name){
		this.str60Name = str60Name;
	}

//----------------------�{�ԗp�R���X�g���N�^---------------------------
//60���ނ̓������A�ڍׁA12���ނ�id�A���l�ڍׁA�F�B�ڍׁA�d�����ԏڍ�

	public Animal_DTO (String str60Name,int int12Id, String strDetail,
										 String strLover_detail,String strFriend_detail, String strWork_detail){
	//���[�U�[�̏����
		this.str60Name = str60Name;
		this.int12Id = int12Id;
		this.strDetail = strDetail;
		this.strLover_detail =strLover_detail;
		this.strFriend_detail = strFriend_detail;
		this.strWork_detail = strWork_detail;
	}



//SET���\�b�h
//���l
  public void setStrLover_name(String strLover_name){
    this.strLover_name = strLover_name;
  }
  public void setStrLover_ad(String strLover_ad){
    this.strLover_ad = strLover_ad;
  }

//�F�l
  public void setStrFriend_name(String strFriend_name){
    this.strFriend_name = strFriend_name;
  }
  public void setStrFriend_ad(String strFriend_ad){
    this.strFriend_ad = strFriend_ad;
  }
//�d������

  public void setStrWork_name(String strWork_name){
    this.strWork_name = strWork_name;
  }
  public void setStrWork_ad(String strWork_ad){
    this.strWork_ad = strWork_ad;
  }


//GET���\�b�h
//���[�U�[
  public String getStr60Name(){
    return str60Name;
  }
  public String getStrDetail(){
    return strDetail;
  }
//���l
  public String getStrLover_name(){
    return strLover_name;
  }
  public String getStrLover_detail(){
    return strLover_detail;
  }
  public String getStrLover_ad(){
    return strLover_ad;
  }

//�F�l
  public String getStrFriend_name(){
    return strFriend_name;
  }
  public String getStrFriend_detail(){
    return strFriend_detail;
  }
  public String getStrFriend_ad(){
    return strFriend_ad;
  }

//�d������
  public String getStrWork_name(){
    return strWork_name;
  }
  public String getStrWork_detail(){
    return strWork_detail;
  }
  public String getStrWork_ad(){
    return strWork_ad;
  }
//�P�Q����ID
  public int getInt12Id(){
    return int12Id;
  }
}