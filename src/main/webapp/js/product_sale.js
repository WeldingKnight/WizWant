//json으로 nav텝 목록 담기
var tmpObj = new Object();
var tmpArr;
tmpArr = [
	['조립','브랜드(삼성,LG,애플)','브랜드(기타)'],
	['애플','삼성,LG','기타 브랜드'],
	['애플','삼성,LG','기타 브랜드'],
	['하의','상의','그 외'],
	['남','여','브랜드 별']
];
tmpObj.small     = tmpArr;
var Json = JSON.stringify(tmpObj);


function setDiv(name, index){
	var html = '';
	for(var i=0;i<tmpObj.small[index].length; i++){
		html += '<option value="'+tmpObj.small[index][i]+'">' +tmpObj.small[index][i]+'</option>\n';
	}
	console.log(html);
	$('#detail_'+name).html(html);  
	$('#detail_'+name).show();
}
	
//상위 셀렉트로 하위 셀렉트 제어하기
function showSub(hrefVal) { 
	console.log(hrefVal);
    if(hrefVal == "digital") {
        $("#digital").attr("selected","selected");
        
        $("#detail_mid1").show();
        $("#detail_mid2").hide();
        $("#detail_mid3").hide();
        $("#detail_mid4").hide();
        $("#detail_sm3").hide();
        $("#detail_sm4").hide();
        $("#detail_sm5").hide();
      
        $("#detail_sm3").html("");
        $("#detail_sm4").html("");
        $("#detail_sm5").html("");
    } else if(hrefVal == "tel") {
        $("#tel").attr("selected","selected");
        
        setDiv("sm3", 2);
        
        $("#detail_mid1").hide();
        $("#detail_mid2").show();
        $("#detail_mid3").hide();
        $("#detail_mid4").hide();
        $("#detail_sm1").hide();
        $("#detail_sm2").hide();
        $("#detail_sm4").hide();
        $("#detail_sm5").hide();
        
        $("#detail_sm1").html("");
        $("#detail_sm2").html("");
        $("#detail_sm4").html("");
        $("#detail_sm5").html("");
    } else if(hrefVal == "clothing") {
        $("#clothing").attr("selected","selected");

        setDiv("sm4", 3);
        
        $("#detail_mid1").hide();
        $("#detail_mid2").hide();
        $("#detail_mid3").show();
        $("#detail_mid4").hide();
        $("#detail_sm1").hide();
        $("#detail_sm2").hide();
        $("#detail_sm3").hide();
        $("#detail_sm5").hide();
        
        $("#detail_sm1").html("");
        $("#detail_sm2").html("");
        $("#detail_sm3").html("");
        $("#detail_sm5").html("");
    } else if(hrefVal == "grocery") {
        $("#grocery").attr("selected","selected");
        
        setDiv("sm5", 4);
        
        $("#detail_mid1").hide();
        $("#detail_mid2").hide();
        $("#detail_mid3").hide();
        $("#detail_mid4").show();
        $("#detail_sm1").hide();
        $("#detail_sm2").hide();
        $("#detail_sm3").hide();
        $("#detail_sm4").hide();
        
        $("#detail_sm1").html("");
        $("#detail_sm2").html("");
        $("#detail_sm3").html("");
        $("#detail_sm4").html("");
    } 
}
function showSub2(hrefVal2) {
	if(hrefVal2 == 1){
		setDiv("sm1", 0);
		$("#detail_sm2").html("");
		$("#detail_sm2").hide();
	}
	else{        
		setDiv("sm2", 1);
		$("#detail_sm1").html("");
		$("#detail_sm1").hide();
	}
}