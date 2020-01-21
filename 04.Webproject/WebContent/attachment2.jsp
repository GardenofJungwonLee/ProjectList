<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
 --><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>attachment</title>
<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha266-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<style>
td , h4{text-align:center;}
tbody tr td:first-child {text-align:left;}
input[type='radio'] {visibility: hidden;}
input[type='radio']:after {width:1.5em;height:1.5em;
        border-radius: 0.75em;
        background-color: #fff;
        content: '';
        display: inline-block;
        visibility: visible;
        border: 2px solid #8d8d8e;}
input[type='radio']:checked:after {
        background-color: #83ef07;
        content: '';
        display: inline-block;
        visibility: visible;
        border: 2px solid #8d8d8e;
  }      
</style>        
<div class="container">        
	<div class="row">
  	<div class="col-md-12">      
    <h4>${sessionScope.id} 님의 Lovetype</h4>    
    <div class="table-responsive">      
        <form action="control" class="form-horizontal" >  
 <!-- <form id="research" action="control" class="form-horizontal" >   -->
         <input type="hidden" name="command" value="attachInsert">
		<input type="hidden" name="id" value= ${sessionScope.id}>
         
    <button  type="submit" id="actres" class="btn btn-primary" style="width: 100%;" data-toggle="modal" data-target="#result" >결과보기</button>
        <table class="table">                
        <thead>
        <tr>
       <td>문항</td>
       <td>전혀그렇지않다</td>  
       <td>그렇지않다</td>
       <td>보통이다</td>
	   <td>대체로그렇다</td>
	   <td>매우그렇다</td>
	   </tr>  
	</thead>
	<tbody>
	<tr>  
	   <td>1.내가 얼마나 호감을 가지고 있는지 상대방에게 보이고 싶지 않다</td>
	   <td><input class="attach" type="radio" name="answer1" value="1"/></td>
	   <td><input class="attach" type="radio" name="answer1" value="2"/></td>
	   <td><input class="attach" type="radio" name="answer1" value="3"/></td>
	   <td><input class="attach" type="radio" name="answer1" value="4"/></td>
	   <td><input class="attach" type="radio" name="answer1" value="5"/></td>  
    </tr>    
    <tr>  
	   <td>2.나는 버림을 받는 것에 대해 걱정하는 편이다</td>
	   <td><input class="attach" type="radio" name="answer2" value="1"/></td>
	   <td><input class="attach" type="radio" name="answer2" value="2"/></td>
	   <td><input class="attach" type="radio" name="answer2" value="3"/></td>
	   <td><input class="attach" type="radio" name="answer2" value="4"/></td>
	   <td><input class="attach" type="radio" name="answer2" value="5"/></td>  
    </tr>
    <tr>  
	   <td>3.나는 다른 사람과 가까워지는 것이 매우 편안하다</td>
	   <td><input class="attach" type="radio" name="answer3" value="1"/></td>
	   <td><input class="attach" type="radio" name="answer3" value="2"/></td>
	   <td><input class="attach" type="radio" name="answer3" value="3"/></td>
	   <td><input class="attach" type="radio" name="answer3" value="4"/></td>
	   <td><input class="attach" type="radio" name="answer3" value="5"/></td>  
    </tr>
    <tr>  
	   <td>4.나는 다른 사람과의 관계에 대해 많이 걱정하는 편이다</td>
	   <td><input class="attach" type="radio" name="answer4" value="1"/></td>
	   <td><input class="attach" type="radio" name="answer4" value="2"/></td>
	   <td><input class="attach" type="radio" name="answer4" value="3"/></td>
	   <td><input class="attach" type="radio" name="answer4" value="4"/></td>
	   <td><input class="attach" type="radio" name="answer4" value="5"/></td>  
    </tr>
<!--     <tr>  
	   <td>5.상대방이 막 나와 친해지려고 할 때 꺼려하는 나를 발견한다</td>
	   <td><input class="attach" type="radio" name="s5" value="1"/></td>
	   <td><input class="attach" type="radio" name="s5" value="2"/></td>
	   <td><input class="attach" type="radio" name="s5" value="3"/></td>
	   <td><input class="attach" type="radio" name="s5" value="4"/></td>
	   <td><input class="attach" type="radio" name="s5" value="5"/></td>  
    </tr>
    <tr>  
	   <td>6.내가 다른 사람에게 관심을 가지는 만큼 그들이 나에게 관심을 가지지 않을까봐 걱정이다</td>
	   <td><input class="attach" type="radio" name="s6" value="1"/></td>
	   <td><input class="attach" type="radio" name="s6" value="2"/></td>
	   <td><input class="attach" type="radio" name="s6" value="3"/></td>
	   <td><input class="attach" type="radio" name="s6" value="4"/></td>
	   <td><input class="attach" type="radio" name="s6" value="5"/></td>  
    </tr>
    <tr>  
	   <td>7.나는 다른 사람이 나와 매우 가까워지려 할 때 불편하다</td>
	   <td><input class="attach" type="radio" name="s7" value="1"/></td>
	   <td><input class="attach" type="radio" name="s7" value="2"/></td>
	   <td><input class="attach" type="radio" name="s7" value="3"/></td>
	   <td><input class="attach" type="radio" name="s7" value="4"/></td>
	   <td><input class="attach" type="radio" name="s7" value="5"/></td>  
    </tr>
    <tr>  
	   <td>8.나는 나와 친한 사람을 잃을까봐 꽤 걱정이 된다</td>
	   <td><input class="attach" type="radio" name="s8" value="1"/></td>
	   <td><input class="attach" type="radio" name="s8" value="2"/></td>
	   <td><input class="attach" type="radio" name="s8" value="3"/></td>
	   <td><input class="attach" type="radio" name="s8" value="4"/></td>
	   <td><input class="attach" type="radio" name="s8" value="5"/></td>  
    </tr>
    <tr>  
	   <td>9.나는 다른 사람에게 마음을 여는 것이 편안하지 못하다</td>
	   <td><input class="attach" type="radio" name="s9" value="1"/></td>
	   <td><input class="attach" type="radio" name="s9" value="2"/></td>
	   <td><input class="attach" type="radio" name="s9" value="3"/></td>
	   <td><input class="attach" type="radio" name="s9" value="4"/></td>
	   <td><input class="attach" type="radio" name="s9" value="5"/></td>  
    </tr>
    <tr>  
	   <td>10.나는 종종 내가 상대방에게 호의를 보이는 만큼 상대방도 그렇게 해 주기를 바란다</td>
	   <td><input class="attach" type="radio" name="s10" value="1"/></td>
	   <td><input class="attach" type="radio" name="s10" value="2"/></td>
	   <td><input class="attach" type="radio" name="s10" value="3"/></td>
	   <td><input class="attach" type="radio" name="s10" value="4"/></td>
	   <td><input class="attach" type="radio" name="s10" value="5"/></td>  
    </tr>
    <tr>  
	   <td>11.나는 상대방과 가까워지기를 원하지만 나는 생각을 바꾸어 그만둔다</td>
	   <td><input class="attach" type="radio" name="s11" value="1"/></td>
	   <td><input class="attach" type="radio" name="s11" value="2"/></td>
	   <td><input class="attach" type="radio" name="s11" value="3"/></td>
	   <td><input class="attach" type="radio" name="s11" value="4"/></td>
	   <td><input class="attach" type="radio" name="s11" value="5"/></td>  
    </tr>
    <tr>  
	   <td>12.나는 상대방과 하나가 되길 원하기 때문에 사람들이 때때로 나에게서 멀어진다</td>
	   <td><input class="attach" type="radio" name="s12" value="1"/></td>
	   <td><input class="attach" type="radio" name="s12" value="2"/></td>
	   <td><input class="attach" type="radio" name="s12" value="3"/></td>
	   <td><input class="attach" type="radio" name="s12" value="4"/></td>
	   <td><input class="attach" type="radio" name="s12" value="5"/></td>  
    </tr>
    <tr>  
	   <td>13.나는 다른 사람이 나와 너무 가까워졌을 때 예민해진다</td>
	   <td><input class="attach" type="radio" name="s13" value="1"/></td>
	   <td><input class="attach" type="radio" name="s13" value="2"/></td>
	   <td><input class="attach" type="radio" name="s13" value="3"/></td>
	   <td><input class="attach" type="radio" name="s13" value="4"/></td>
	   <td><input class="attach" type="radio" name="s13" value="5"/></td>  
    </tr>
    <tr>  
	   <td>14.나는 혼자 남겨질까봐 걱정이다</td>
	   <td><input class="attach" type="radio" name="s14" value="1"/></td>
	   <td><input class="attach" type="radio" name="s14" value="2"/></td>
	   <td><input class="attach" type="radio" name="s14" value="3"/></td>
	   <td><input class="attach" type="radio" name="s14" value="4"/></td>
	   <td><input class="attach" type="radio" name="s14" value="5"/></td>  
    </tr>
    <tr>  
	   <td>15.나는 다른 사람에게 내 생각과 감정을 이야기하는 것이 편안하다</td>
	   <td><input class="attach" type="radio" name="s15" value="1"/></td>
	   <td><input class="attach" type="radio" name="s15" value="2"/></td>
	   <td><input class="attach" type="radio" name="s15" value="3"/></td>
	   <td><input class="attach" type="radio" name="s15" value="4"/></td>
	   <td><input class="attach" type="radio" name="s15" value="5"/></td>  
    </tr>
    <tr>  
	   <td>16.지나치게 친밀해지고자 하는 욕심 때문에 때로 사람들이 두려워하여 거리를 둔다</td>
	   <td><input class="attach" type="radio" name="s16" value="1"/></td>
	   <td><input class="attach" type="radio" name="s16" value="2"/></td>
	   <td><input class="attach" type="radio" name="s16" value="3"/></td>
	   <td><input class="attach" type="radio" name="s16" value="4"/></td>
	   <td><input class="attach" type="radio" name="s16" value="5"/></td>  
    </tr>
     <tr>  
	   <td>17.나는 상대방과 너무 가까워지는 것을 피하려고 한다</td>
	   <td><input class="attach" type="radio" name="s17" value="1"/></td>
	   <td><input class="attach" type="radio" name="s17" value="2"/></td>
	   <td><input class="attach" type="radio" name="s17" value="3"/></td>
	   <td><input class="attach" type="radio" name="s17" value="4"/></td>
	   <td><input class="attach" type="radio" name="s17" value="5"/></td>  
    </tr>
     <tr>  
	   <td>18.나는 상대방으로부터 사랑받고 있다는 것을 자주 확인받고 싶어한다</td>
	   <td><input class="attach" type="radio" name="s18" value="1"/></td>
	   <td><input class="attach" type="radio" name="s18" value="2"/></td>
	   <td><input class="attach" type="radio" name="s18" value="3"/></td>
	   <td><input class="attach" type="radio" name="s18" value="4"/></td>
	   <td><input class="attach" type="radio" name="s18" value="5"/></td>  
    </tr>
     <tr>  
	   <td>19.나는 다른 사람과 가까워지는 것이 비교적 쉽다</td>
	   <td><input class="attach" type="radio" name="s19" value="1"/></td>
	   <td><input class="attach" type="radio" name="s19" value="2"/></td>
	   <td><input class="attach" type="radio" name="s19" value="3"/></td>
	   <td><input class="attach" type="radio" name="s19" value="4"/></td>
	   <td><input class="attach" type="radio" name="s19" value="5"/></td>  
    </tr>
     <tr>  
	   <td>20.가끔 나는 다른 사람에게, 더 많은 애정과 더 많은 헌신을 보여줄 것을 강요한다</td>
	   <td><input class="attach" type="radio" name="s20" value="1"/></td>
	   <td><input class="attach" type="radio" name="s20" value="2"/></td>
	   <td><input class="attach" type="radio" name="s20" value="3"/></td>
	   <td><input class="attach" type="radio" name="s20" value="4"/></td>
	   <td><input class="attach" type="radio" name="s20" value="5"/></td>  
    </tr>
     <tr>  
	   <td>21.나는 다른 사람에게 의지하기가 어렵다</td>
	   <td><input class="attach" type="radio" name="s21" value="1"/></td>
	   <td><input class="attach" type="radio" name="s21" value="2"/></td>
	   <td><input class="attach" type="radio" name="s21" value="3"/></td>
	   <td><input class="attach" type="radio" name="s21" value="4"/></td>
	   <td><input class="attach" type="radio" name="s21" value="5"/></td>  
    </tr>
     <tr>  
	   <td>22.나는 버림받는 것에 대해 때때로 걱정하지 않는다</td>
	   <td><input class="attach" type="radio" name="s22" value="1"/></td>
	   <td><input class="attach" type="radio" name="s22" value="2"/></td>
	   <td><input class="attach" type="radio" name="s22" value="3"/></td>
	   <td><input class="attach" type="radio" name="s22" value="4"/></td>
	   <td><input class="attach" type="radio" name="s22" value="5"/></td>  
    </tr>
     <tr>  
	   <td>23.나는 다른 사람과 너무 가까워지는 것을 좋아하지 않는다</td>
	   <td><input class="attach" type="radio" name="s23" value="1"/></td>
	   <td><input class="attach" type="radio" name="s23" value="2"/></td>
	   <td><input class="attach" type="radio" name="s23" value="3"/></td>
	   <td><input class="attach" type="radio" name="s23" value="4"/></td>
	   <td><input class="attach" type="radio" name="s23" value="5"/></td>  
    </tr>
     <tr>  
	   <td>24.만약 상대방이 나에게 관심을 보이지 않는다면 나는 화가난다</td>
	   <td><input class="attach" type="radio" name="s24" value="1"/></td>
	   <td><input class="attach" type="radio" name="s24" value="2"/></td>
	   <td><input class="attach" type="radio" name="s24" value="3"/></td>
	   <td><input class="attach" type="radio" name="s24" value="4"/></td>
	   <td><input class="attach" type="radio" name="s24" value="5"/></td>  
    </tr>
     <tr>  
	   <td>25.나는 상대방에게 모든 것을 이야기한다</td>
	   <td><input class="attach" type="radio" name="s25" value="1"/></td>
	   <td><input class="attach" type="radio" name="s25" value="2"/></td>
	   <td><input class="attach" type="radio" name="s25" value="3"/></td>
	   <td><input class="attach" type="radio" name="s25" value="4"/></td>
	   <td><input class="attach" type="radio" name="s25" value="5"/></td>  
    </tr>
     <tr>  
	   <td>26.상대방이 내가 원하는 만큼 가까워지는 것을 원치 않음을 안다</td>
	   <td><input class="attach" type="radio" name="s26" value="1"/></td>
	   <td><input class="attach" type="radio" name="s26" value="2"/></td>
	   <td><input class="attach" type="radio" name="s26" value="3"/></td>
	   <td><input class="attach" type="radio" name="s26" value="4"/></td>
	   <td><input class="attach" type="radio" name="s26" value="5"/></td>  
    </tr>
     <tr>  
	   <td>27.나는 대개 다른 사람에게 내 문제와 고민을 상의한다</td>
	   <td><input class="attach" type="radio" name="s27" value="1"/></td>
	   <td><input class="attach" type="radio" name="s27" value="2"/></td>
	   <td><input class="attach" type="radio" name="s27" value="3"/></td>
	   <td><input class="attach" type="radio" name="s27" value="4"/></td>
	   <td><input class="attach" type="radio" name="s27" value="5"/></td>  
    </tr>
    <tr>  
	   <td>28.내가 다른 사람과 교류가 없을 때 나는 다소 걱정스럽고 불안하다</td>
	   <td><input class="attach" type="radio" name="s28" value="1"/></td>
	   <td><input class="attach" type="radio" name="s28" value="2"/></td>
	   <td><input class="attach" type="radio" name="s28" value="3"/></td>
	   <td><input class="attach" type="radio" name="s28" value="4"/></td>
	   <td><input class="attach" type="radio" name="s28" value="5"/></td>  
    </tr>
    <tr>  
	   <td>29.다른 사람에게 의지하는 것이 편안하다</td>
	   <td><input class="attach" type="radio" name="s29" value="1"/></td>
	   <td><input class="attach" type="radio" name="s29" value="2"/></td>
	   <td><input class="attach" type="radio" name="s29" value="3"/></td>
	   <td><input class="attach" type="radio" name="s29" value="4"/></td>
	   <td><input class="attach" type="radio" name="s29" value="5"/></td>  
    </tr>
    <tr>  
	   <td>30.상대방이 내가 원하는 만큼 가까이에 있지 않을 때 실망하게 된다</td>
	   <td><input class="attach" type="radio" name="s30" value="1"/></td>
	   <td><input class="attach" type="radio" name="s30" value="2"/></td>
	   <td><input class="attach" type="radio" name="s30" value="3"/></td>
	   <td><input class="attach" type="radio" name="s30" value="4"/></td>
	   <td><input class="attach" type="radio" name="s30" value="5"/></td>  
    </tr>
    <tr>  
	   <td>31.나는 상대방에게 위로, 조언, 또는 도움을 청하지 못한다</td>
	   <td><input class="attach" type="radio" name="s31" value="1"/></td>
	   <td><input class="attach" type="radio" name="s31" value="2"/></td>
	   <td><input class="attach" type="radio" name="s31" value="3"/></td>
	   <td><input class="attach" type="radio" name="s31" value="4"/></td>
	   <td><input class="attach" type="radio" name="s31" value="5"/></td>  
    </tr>
    <tr>  
	   <td>32.내가 필요로 할 때 상대방이 거절한다면 실망하게 된다</td>
	   <td><input class="attach" type="radio" name="s32" value="1"/></td>
	   <td><input class="attach" type="radio" name="s32" value="2"/></td>
	   <td><input class="attach" type="radio" name="s32" value="3"/></td>
	   <td><input class="attach" type="radio" name="s32" value="4"/></td>
	   <td><input class="attach" type="radio" name="s32" value="5"/></td>  
    </tr>
    <tr>  
	   <td>33.내가 필요로 할 때 상대방에게 의지하는 게 도움이 된다</td>
	   <td><input class="attach" type="radio" name="s33" value="1"/></td>
	   <td><input class="attach" type="radio" name="s33" value="2"/></td>
	   <td><input class="attach" type="radio" name="s33" value="3"/></td>
	   <td><input class="attach" type="radio" name="s33" value="4"/></td>
	   <td><input class="attach" type="radio" name="s33" value="5"/></td>  
    </tr>
    <tr>  
	   <td>34.상대방이 나에게 불만을 나타낼 때 나 자신이 정말 형편없게 느껴진다</td>
	   <td><input class="attach" type="radio" name="s34" value="1"/></td>
	   <td><input class="attach" type="radio" name="s34" value="2"/></td>
	   <td><input class="attach" type="radio" name="s34" value="3"/></td>
	   <td><input class="attach" type="radio" name="s34" value="4"/></td>
	   <td><input class="attach" type="radio" name="s34" value="5"/></td>  
    </tr>
    <tr>  
	   <td>35.나는 위로와 확신을 비롯한 많은 일들을 상대방에게 의지한다</td>
	   <td><input class="attach" type="radio" name="s35" value="1"/></td>
	   <td><input class="attach" type="radio" name="s35" value="2"/></td>
	   <td><input class="attach" type="radio" name="s35" value="3"/></td>
	   <td><input class="attach" type="radio" name="s35" value="4"/></td>
	   <td><input class="attach" type="radio" name="s35" value="5"/></td>  
    </tr>
    <tr>  
	   <td>36.상대방이 나를 떠나서 많은 시간을 보내면 나는 불쾌하다</td>
	   <td><input class="attach" type="radio" name="s36" value="1"/></td>
	   <td><input class="attach" type="radio" name="s36" value="2"/></td>
	   <td><input class="attach" type="radio" name="s36" value="3"/></td>
	   <td><input class="attach" type="radio" name="s36" value="4"/></td>
	   <td><input class="attach" type="radio" name="s36" value="5"/></td>  
    </tr> -->
   
    </tbody>
    </table>
    </form>
	
	<!--  
	
	<input type="submit" value="결과" class="btn btn-primary">
    </div>
    /.model-content
    </div>
    /.model-dialog
    </div>
    
    
    <div class="modal fade" id="result" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
    <div class="modal-header">
    <h4 class="modal-title custom_align" id="Heading">애착유형 결과</h4>
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">결과확인하기</button>        
    </div>
    <div class="modal-body">
            <div class="form-group">
            총점: <input class="form-control " type="text" name="sum" readonly />
    </div>
            <div class="form-group">
            유형명 : <input class="form-control " type="text" name="attachtype" readonly />
    </div>
            <div class="form-group">
            유형설명 : <textarea rows="4" class="form-control" id="itemtypelist" readonly /></textarea>  
              
    </div>
    </div>
    <div class="modal-footer">
    </div>
    </div>
    /.model-content
    </div>
    /.model-dialog
    </div>
    
    </div>
    
    <script>
    	function attachscore(){
    		var score=0;
    		var score1=0;
    		var isResult = true;
    		var itemResult=new Array();
    		var itemlist="";
    		$(".attach:checked").each(function(){
    	        score+=parseInt($(this).val(),10);
    		});
    	    $("input[name=sum]").val(score);
    	    var attachtypeArray = new Array("모호형","친밀형","예민형");
    	    var itemtypeArray = new Array(" 적절한 감정표현에 서툴거나 무관심한 양상을 나타냅니다. 자신을 보호하기 위해 애착 욕구를 차단하며 깊이 있는 유대감을 형성하는 것을 피하는 편입니다.", "믿음직한 타입으로 상대방과 안정적이면서도 정서적 균형이 잘 유지되는 관계을 형성합니다. 또한 필요한 경우 타인의 도움을 불편하게 느끼지 않으며 배신당하고 버려지리라는 염려로 시간을 낭비하지 않습니다. ", " 관계를 형성함에 있어 쉽게 불안해하거나 분노하는 등의 감정기복이 심한 태도를 보입니다. 다른 사람과의 친밀하고 긴밀한 유대관계를 형성할 때 감정에 압도되고, 언제 상대방으로부터 거절당할지 모른다는 걱정이 앞서며, 습관적으로 자신을 사랑하는지를 상대방에게 묻습니다.");
    	    if(score < 50)  {	
    	    	$("input[name=attachtype]").val(attachtypeArray[0]);            
    	        itemResult[0] = itemtypeArray[0]; 
    	    }
    	    else if(score < 130) {
    	    	$("input[name=attachtype]").val(attachtypeArray[1]);
    	    	itemResult[0] = itemtypeArray[1];
    	    }	
    	    else { 
    	    	itemResult[0] = itemtypeArray[2];
    	    	$("input[name=attachtype]").val(attachtypeArray[2]);

    	    } 
    	    for(k=0;k<itemResult.length;k++){
    	    	if(itemResult[k]){
    	    		itemlist = itemlist +  itemResult[k];
    	    	} 
    	    }
    	    $("#itemtypelist").val(itemlist);
    	    var rsrchChk = $("#research input[type=radio]");
    	    $(':radio').each(function () {
    	    	name = $(this).attr('name');
    	    	if (isResult && !$(':radio[name="' + name + '"]:checked').length){ isResult = false;}
    	    	console.log(isResult);
    	    });
    	    
    	    if(isResult) $("#actres").show();
    	}
    	$().ready(function(){
    		$("#actres").hide();
    	    $("input").change(function(){	
    	       attachscore()
    	    });
    	});     -->
    
    
    
    </script>
    </body>
    </html>
    
    
    
    
    
    
        
        
        
        
        
        
        
        