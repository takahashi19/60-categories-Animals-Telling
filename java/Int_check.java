public class Int_check {

//�`�F�b�N���\�b�h----------------------------------------------------
	public static boolean checker(String intYear,String intMonth, String intDay) {
/*
�s��������������^�U�ł������߂�
�s���Ȃ��u false �v
�s������u true �v
*/
		boolean checker = false;
//�uint�^�v�ɕϊ��ł��邩�Ŕ���
		try{
			Integer.parseInt(intYear);
			Integer.parseInt(intMonth);
			Integer.parseInt(intDay);
			return checker;
//�s�������Btrue�ŕԂ��B
		}catch(NumberFormatException e){
			checker = true;
			return checker;
		}
	}
//���C�����\�b�h-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		boolean checker = checker("1927","9","6");
		System.out.println(checker); 
	}
}

 
 