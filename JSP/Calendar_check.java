package animal_ft;

import java.util.Calendar;
public class  Calendar_check{

//�`�F�b�N���\�b�h----------------------------------------------------
	public static boolean checker(int intYear,int intMonth, int intDay) {
    Calendar cl = Calendar.getInstance();
//���������
		int year	= intYear;
		int month = intMonth;
		int day		= intDay;
//�J�����_�[�̔N���������ɕύX
		cl.set(year,month,day);

//�s��������������^�U�ł������߂�B��������true�B
		boolean checker = false;

		if (year != cl.get(Calendar.YEAR)){
			checker = true;
		}else if (month != cl.get(Calendar.MONTH)){
			checker = true;
		}else if (day != cl.get(Calendar.DATE)){
			checker = true;
		}
		return checker;
	}


//���C�����\�b�h-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		boolean checker = checker(1999,12,32);

		System.out.println(checker); 
	}
}


/*�J�����_�[�̔N������\��
		System.out.println("YEAR�F" + cl.get(Calendar.YEAR));
		System.out.println("MONTH�F" + cl.get(Calendar.MONTH)); 
		System.out.println("DATE�F" + cl.get(Calendar.DATE)); 
*/   

/*�ύX��̔N������\��
		System.out.println("YEAR�F" + cl.get(Calendar.YEAR));
		System.out.println("MONTH�F" + cl.get(Calendar.MONTH)); 
		System.out.println("DATE�F" + cl.get(Calendar.DATE));        
*/