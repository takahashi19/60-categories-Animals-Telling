public class Int_check {

//チェックメソッド----------------------------------------------------
	public static boolean checker(String intYear,String intMonth, String intDay) {
/*
不備があったかを真偽でたしかめる
不備なし「 false 」
不備あり「 true 」
*/
		boolean checker = false;
//「int型」に変換できるかで判定
		try{
			Integer.parseInt(intYear);
			Integer.parseInt(intMonth);
			Integer.parseInt(intDay);
			return checker;
//不備発見。trueで返す。
		}catch(NumberFormatException e){
			checker = true;
			return checker;
		}
	}
//メインメソッド-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		boolean checker = checker("1927","9","6");
		System.out.println(checker); 
	}
}

 
 