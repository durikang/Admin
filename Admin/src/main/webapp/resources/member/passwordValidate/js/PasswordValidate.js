/**
 *  패스워드 관련 js입니다.
 */
 
 
 function validatePasswords() {
    const password = document.getElementById('pwd').value;
    const passwordConfirm = document.getElementById('pwdConfirm').value;
    const errorSpan = document.getElementById('password-error');
    
    // 비밀번호 규칙 정규식
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{6,}$/;

    if (!passwordPattern.test(password)) {
        errorSpan.textContent = '비밀번호는 6자리 이상, 대문자, 소문자, 특수문자를 포함해야 합니다.';
        return false;
    }

    if (password !== passwordConfirm) {
        errorSpan.textContent = '비밀번호가 일치하지 않습니다.';
        return false;
    }

    errorSpan.textContent = ''; // 에러 메시지 클리어
    return true;
}

document.addEventListener('DOMContentLoaded', function() {
	   
    const pwdInput = document.getElementById('pwd');
    const pwdConfirmInput = document.getElementById('pwdConfirm');

    if (pwdInput && pwdConfirmInput) {
        pwdInput.addEventListener('input', validatePasswords);
        pwdConfirmInput.addEventListener('input', validatePasswords);
    } else {
        console.error('Could not find password input elements');
    }
});