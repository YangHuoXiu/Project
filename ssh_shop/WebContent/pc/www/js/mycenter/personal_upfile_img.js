LT.namespace("LT.personal_upfile_img");var callback;LT.personal_upfile_img=function(){var t,i,e,a=300,n=$(".J_head_img_t"),o=$(".J_head_img_b"),h=$(".J_head_img_l"),s=$(".J_head_img_r"),l=$(".J_drag"),r=$(".J_drag_img"),c=$(".J_bigImgArea"),d=$(".J_uploadfile_btn");e={bindEvent:function(){$(document).delegate(".J_drag","mousedown",function(t){var i=$(this),l=i.height(),c=i.width(),d=r.height(),p=r.width();LT.drag(t,{that:$(this),direction:"xy",callback:function(t,i){n.css({height:i+"px"}),o.css({height:a-i-l}),h.css({width:t+"px",top:i+"px",height:l+"px"}),s.css({width:a-t-c,top:i+"px",height:l+"px"}),e._zoomFn(l,c,d,p,t,i)},scopeEle:r})}),$(document).delegate(".J_drag_bottomright","mousedown",function(t){var i=$(this).parent();return LT.drag(t,{that:$(this),changeEle:i,callback:function(){var t=i.position().left,l=i.position().top,c=i.height(),d=i.width(),p=r.height(),g=r.width();n.css({height:l+"px"}),o.css({height:a-l-c}),h.css({width:t+"px",top:l+"px",height:c+"px"}),s.css({width:a-t-d,top:l+"px",height:c+"px"}),e._zoomFn(c,d,p,g,t,l)},scopeEle:r,bRatio:!0}),t.stopPropagation(),!1}),$("#txtNickname").change(function(){var i={uid:$("#txtEmail").text(),nickname:$("#txtNickname").val()};$.ajax({data:i,type:"POST",dataType:"json",url:window.ControllerSite+"/MyCenter/checkNickname",async:!1,success:function(i){1==i&&$("#nicknameHint").text(""),2==i&&(t=!1,scroll(0,0),$("#nicknameHint").text("昵称已存在!")),3==i&&LT.alertSmall("系统异常请稍后再试!",function(){})}})}),$(document).delegate(".J_save","click",function(i){if($(".J_save").hasClass("masked"))return!1;if($(".J_save").addClass("relative"),$(".J_save").mask(),t=!0,$("#txtNickname").change(),t){if($("#nicknameHint").text(""),""==$.trim($("#txtNickname").val()))return $("#nicknameHint").text("昵称不能为空!"),$(".J_save").unmask(),!1;if(0==$("#J_drag_img").attr("src").length){var e={uid:$("#txtEmail").text(),nickname:$("#txtNickname").val(),gender:$(":radio").parents(".J_gender_select").find("label.checked").find("input:radio").val()};$.ajax({url:window.ControllerSite+"/MyCenter/UpdateCustomProfile",dataType:"json",type:"POST",data:e,success:function(t){$(".J_save").unmask(),1==t&&LT.alertSmall("保存成功",function(){window.location.reload(!0)})},error:function(){$(".J_save").unmask()},complete:function(){$(".J_save").unmask()}})}else{var e={uid:$("#txtEmail").text(),nickname:$("#txtNickname").val(),gender:$(":radio").parents(".J_gender_select").find("label.checked").find("input:radio").val()},a=l.position().left-r.position().left,n=l.position().top-r.position().top,o=l.width(),h=l.height(),s={};s.l=0>a?0:a,s.t=0>n?0:n,s.w=o,s.h=h,s.imgsrc=r.attr("src"),$.ajax({url:window.ControllerSite+"/MyCenter/UpdateCustomProfile",dataType:"json",type:"POST",data:e,success:function(t){1==t&&$.ajax({url:window.ControllerSite+"/MyCenter/SaveAvatar",dataType:"json",type:"POST",data:s,success:function(t){1==t.state?($(".per_leftul").children("li").eq(0).find("img").attr("src",t.data),LT.alertSmall("保存成功",function(){window.location.reload(!0)})):LT.alertSmall(t.msg)},error:function(){}})},error:function(){}}),i.preventDefault()}}}),d.on("change",function(){var t=$(this).val().substring($(this).val().lastIndexOf(".")+1).toLowerCase();"jpg"!=t&&"gif"!=t&&"png"!=t?LT.alertSmall("请上传格式为JPG，GIF，PNG。"):$(this).parents("form").trigger("submit")})},_zoomFn:function(t,i,e,a,n,o){var h=(n-r.position().left)/(a-i),s=(o-r.position().top)/(e-t),l=$(".bigimg"),c=l.height(),d=l.width(),p=l.children("img");p.css({width:a/i*d+"px",height:e/i*c+"px"}),p.css({left:-h*(p.width()-d)+"px",top:-s*(p.height()-c)+"px"});var g=$(".middleimg"),m=g.height(),u=g.width(),f=g.children("img");f.css({width:a/i*u+"px",height:e/i*m+"px"}),f.css({left:-h*(f.width()-u)+"px",top:-s*(f.height()-m)+"px"});var x=$(".smallimg"),_=x.height(),w=x.width(),v=x.children("img");v.css({width:a/i*w+"px",height:e/i*_+"px"}),v.css({left:-h*(v.width()-w)+"px",top:-s*(v.height()-_)+"px"})}},i=function(){for(var t in e)-1==t.indexOf("_")&&e[t]()}(),callbackError=function(){LT.alertSmall("图片大小不能超过2M。")},callback=function(t,i,d,p,g){if(1==t){$("#uploadfile").empty(),$("#uploadfile2").empty(),$(".per_upfileImgBox").hide(),$(".per_upfileImgBox").eq(1).show(),r.attr({src:g,width:d,height:p}),c.removeClass("falls_loading"),$(".bigimg img").attr({src:g,width:d,height:p}),$(".middleimg img").attr({src:g,width:d,height:p}),$(".smallimg img").attr({src:g,width:d,height:p}),l.css({width:"150px",height:"150px"}),r.css({left:(c.width()-r.width())/2+"px",top:(c.height()-r.height())/2+"px"}),l.css({left:(c.width()-l.width())/2+"px",top:(c.height()-l.height())/2+"px"});var m=l.position().left,u=l.position().top,f=l.height(),x=l.width(),_=r.height(),w=r.width();n.css({height:u+"px"}),o.css({height:a-u-f}),h.css({width:m+"px",top:u+"px",height:f+"px"}),s.css({width:a-m-x,top:u+"px",height:f+"px"}),e._zoomFn(f,x,_,w,m,u)}else LT.alertSmall(i)}},$(function(){LT.personal_upfile_img()});