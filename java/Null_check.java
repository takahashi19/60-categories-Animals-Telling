public class Null_check {
//チェックメソッド----------------------------------------------------
	public static String checker(String strName,String intYear,String intMonth, String intDay) {
/*
nullがあったかを確かめる。
なければ「 nullなし 」
あったら「 入力に漏れがあります 」を返す。
*/
		String checker = "nullなし";
//null判定
		if (strName == null || intYear==null || intMonth == null || intDay == null){
			checker = "入力に漏れがあります";
		}
		return checker;
		
	}
//メインメソッド-------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		String memoNULL = null;

		String checker =  checker("ねこ", "1927", "ごま", "6");
		System.out.println(checker); 

		checker = checker("ねこ", "1927", memoNULL, "6");
		System.out.println(checker); 
	}
}

 
 