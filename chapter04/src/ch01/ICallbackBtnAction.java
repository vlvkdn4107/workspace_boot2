package ch01;

/**1.인터페이스를 선언 한다
 * 
 * @author 임우성
 * 콜백 메서드 만드는 연습
 */
public interface ICallbackBtnAction {

	public abstract void clickedAddBtn();
	public abstract void clickedMinusBtn();
	public abstract void clickedMaxBtn(int result);
	void pass(int result);
}
