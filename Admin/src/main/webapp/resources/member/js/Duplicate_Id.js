/**
 *  중복체크 ajax 관련 로직입니다.
 */
 
 function checkIdDuplicate() {
    const memId = document.querySelector('input[name="memId"]').value;
    const errorSpan = document.getElementById('id-error');

    // 아이디를 입력하지 않은 경우
    if (!memId) {
        errorSpan.textContent = '아이디를 입력해주세요.';
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open('POST', '${contextPath}/checkIdDuplicate.do', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.onload = function() {
        if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);

            if (response.isDuplicate) {
                errorSpan.textContent = '이미 사용 중인 아이디입니다.';
                errorSpan.style.color = 'red';
            } else {
                errorSpan.textContent = '사용 가능한 아이디입니다.';
                errorSpan.style.color = 'green';
            }
        } else {
            errorSpan.textContent = '서버 오류가 발생했습니다. 다시 시도해주세요.';
        }
    };

    xhr.onerror = function() {
        errorSpan.textContent = '네트워크 오류가 발생했습니다. 다시 시도해주세요.';
    };

    xhr.send('memId=' + encodeURIComponent(memId));
}
document.addEventListener('DOMContentLoaded', function() {
    const memIdInput = document.querySelector('input[name="memId"]');
    
    if (memIdInput) {
        memIdInput.addEventListener('blur', checkIdDuplicate);
    } else {
        console.error('Could not find input element with name "memId"');
    }
});