package animal_ft;

import java.util.Calendar;
public class  Calendar_check{

//チェックメソッド----------------------------------------------------
	public static boolean checker(int intYear,int intMonth, int intDay) {
    Calendar cl = Calendar.getInstance();
//引数★代入
		int year	= intYear;
		int month = intMonth;
		int day		= intDay;
//カレンダーの年月日を★に変更
		cl.set(year,month,day);

//不備があったかを真偽でたしかめる。あったらtrue。
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


//メインメソッド-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		boolean checker = checker(1999,12,32);

		System.out.println(checker); 
	}
}


/*カレンダーの年月日を表示
		System.out.println("YEAR：" + cl.get(Calendar.YEAR));
		System.out.println("MONTH：" + cl.get(Calendar.MONTH)); 
		System.out.println("DATE：" + cl.get(Calendar.DATE)); 
*/   

/*変更後の年月日を表示
		System.out.println("YEAR：" + cl.get(Calendar.YEAR));
		System.out.println("MONTH：" + cl.get(Calendar.MONTH)); 
		System.out.println("DATE：" + cl.get(Calendar.DATE));        
*/