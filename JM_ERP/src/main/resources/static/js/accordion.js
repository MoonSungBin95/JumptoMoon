var headingOne = document.getElementById("headingOne");
var list = document.querySelector(".accordion-body");
var link = list.querySelectorAll(".dropdown-item");

window.onload = function() {
	
	for(var i=0; i<link.length; i++){
		link[i].addEventListener("click", () => {
			headingOne.querySelector("accordion-button").classList.add(" collapsed");
			headingOne.querySelector("accordion-button").setAttribute("aria-expanded","false");
			list.parentElement.classList.replace("show", "");
		});
	};
};