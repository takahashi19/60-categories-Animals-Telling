public class Null_check {
//�`�F�b�N���\�b�h----------------------------------------------------
	public static String checker(String strName,String intYear,String intMonth, String intDay) {
/*
null�������������m���߂�B
�Ȃ���΁u null�Ȃ� �v
��������u ���͂ɘR�ꂪ����܂� �v��Ԃ��B
*/
		String checker = "null�Ȃ�";
//null����
		if (strName == null || intYear==null || intMonth == null || intDay == null){
			checker = "���͂ɘR�ꂪ����܂�";
		}
		return checker;
		
	}
//���C�����\�b�h-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		String memoNULL = null;

		String checker =  checker("�˂�", "1927", "����", "6");
		System.out.println(checker); 

		checker = checker("�˂�", "1927", memoNULL, "6");
		System.out.println(checker); 
	}
}

 
 