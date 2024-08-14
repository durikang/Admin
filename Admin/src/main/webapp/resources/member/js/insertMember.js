/**
 * 비밀번호 유효성 검사
 * 
 * 비밀번호가 최소 6자 이상이어야 하며, 
 * 영문 대문자와 소문자, 숫자 및 특수문자를 포함해야 합니다.
 * 또한, 비밀번호와 비밀번호 확인 값이 일치하는지 확인합니다.
 *
 * @returns {boolean} 유효성 검사에 성공하면 true, 실패하면 false를 반환
 */

// 주소 검색 API 호출
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			document.getElementById("addr").value = data.address;
		}
	}).open();
}