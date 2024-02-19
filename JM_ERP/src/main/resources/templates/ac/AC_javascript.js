// 오늘 날짜를 가져오는 함수
function getTodayDate() {
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); // 1월은 0으로 시작하므로 1을 더해줍니다.
    var yyyy = today.getFullYear();

    return yyyy + '-' + mm + '-' + dd;
}

function selectRadioBtn(selectedOption, option1, option2, option1Content, option2Content) {

    if (selectedOption === option1) {
        $(option1Content).show();
        $(option2Content).hide();
    } else if (selectedOption === option2) {
        $(option1Content).hide();
        $(option2Content).show();
    }
    $("input[name='btnradio'][value='" + selectedOption + "']").prop('checked', true);

    // 라디오 버튼 변경 시 로컬 스토리지에 저장
    $("input[name='btnradio']").change(function () {
        selectedOption = $(this).val();
        localStorage.setItem('selectedOption', selectedOption);
        
        // 페이지를 0으로 설정
        localStorage.setItem('currentPage', 0);
        
        // 현재 URL에서 페이지 파라미터를 제거한 뒤 페이지를 0으로 설정하여 리로드
        var currentUrl = window.location.href.split('?')[0];
        window.location.href = currentUrl + "?page=0";
    });
}

// 수정 버튼 클릭 시 모달 열기
function openAndCloseModal(thisNumber, submitNumber, thisModal) {
    // 클릭된 버튼이 속한 행을 찾습니다.
    var $row = $(this).closest('tr');
    // 행에서 첫 번째 열의 텍스트(채권이나 채무 번호)를 가져옵니다.
    var number = $row.find('td:first').text().trim();
    // 가져온 채권 번호를 출력합니다.
	$(thisNumber).text(number);
	$(submitNumber).val(number);
    // 모달 열기
    $(thisModal).modal('show');

    // 모달 닫기 버튼 클릭 시 모달 닫기
    $(document).on('click', '.close', function() {
        $(thisModal).modal('hide');
	});	    
}

// 추가 / 할인 버튼을 선택시 추가 입력 필드란 보이게 하기
function showPriceField(type, priceLabel, priceLabelName) {
    var selectBox = document.getElementById(type);
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    var PL = document.getElementById(priceLabel);

    if (selectedValue === "추가") {
        PL.style.display = "block";
        document.getElementById(priceLabelName).textContent = "추가 금액:";
    } else if (selectedValue === "할인") {
        PL.style.display = "block";
        document.getElementById(priceLabelName).textContent = "할인 금액:";
    } else {
        PL.style.display = "none";
	}
}

function updateByModal(event, priceField, amount, maturityDate, form) {
	// 폼 안에 있는 입력 요소들의 값을 가져옴
	var PF = $(priceField).val();
	var AT = $(amount).val();
	var MD = $(maturityDate).val();
	
	// 증감 구분, 만기일자가 null 값이고, 변제 금액이 0인 경우 폼 제출을 막음
	if (PF === '0' && !MD && AT === '0') {
	    event.preventDefault(); // 폼 제출 막기
	    alert('하나 이상의 변경값을 입력해 주세요.'); // 사용자에게 알림
	} else {
	    $(form).submit(); // 조건이 충족되면 폼 제출
	}
}