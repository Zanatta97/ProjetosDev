<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" ValidateRequest="false" CodeFile="StartPage.aspx.cs" Inherits="MCR.StartPage" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/StartPage.css" OrderIndex="1"/>
		</StyleSheets>
	</telerik:RadStyleSheetManager>
	<telerik:RadCodeBlock ID="CustomHeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
	<telerik:RadCodeBlock ID="HeaderCodeBlock" runat="server">
		<link rel="stylesheet" href="../Styles/animate.min.css" type="text/css" media="screen" title="no title" charset="utf-8" />
	</telerik:RadCodeBlock>
</head>
<body onload="InitializeClient();" id="Form1_body" style="margin-left:auto;margin-right:auto;">
	<telerik:RadCodeBlock ID="BodyCodeBlock" runat="server">
		<script language="JavaScript" type="text/javascript" src="../JS/jquery.js" ></script>
		<script language="JavaScript" type="text/javascript" src="../JS/wow.min.js" ></script>
		<script type="text/javascript"> new WOW().init(); </script>
		<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
		<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>
			<script language="JavaScript" type="text/javascript" src="../JS/StartPage_USER.js?sv=1.0_20191112113320"></script>
		<script type="text/javascript">
			function OnLoginSucceded()
			{
				 ___Form1_OnLoginSucceded_OnLoginSucceded();
			}
			function TryLogin(PageToRedirect, RefreshControlsID)
			{
				document.forms[0].RefreshControlsIDHidden.value = RefreshControlsID;
				document.forms[0].PageToRedirectHidden.value = PageToRedirect;
			}
			currentPath = "<%= Page.Request.Path %>";
		</script>
	</telerik:RadCodeBlock>
		
	<script type="text/javascript">
		function ___Form1_OnLoginSucceded_OnLoginSucceded()
		{
			var UrlPage = '<%= ResolveUrl("~/Pages/Default.aspx") %>';
			document.location.href = UrlPage;
			return false;
		}
		function ___txtLoginUser_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		function ___txtLoginPassword_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
	</script>
		<form id="Form1" runat="server" class="c_Form1">
		<input type="hidden" name="PageToRedirectHidden" value="" />
		<input type="hidden" name="RefreshControlsIDHidden" value="" />
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<telerik:RadAjaxPanel id="ajxMainAjaxPanel" runat="server" CssClass="c_ajxMainAjaxPanel" LoadingPanelID="___ajxMainAjaxPanel_AjaxLoading">
					<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
						<telerik:RadTextBox id="txtLoginUser" runat="server" AutoPostBack="False" CssClass="c_txtLoginUser" EnableSingleInputRendering="True"
							MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="1" TextMode="SingleLine" WrapperCssClass="c_txtLoginUser_wrapper" />
						<telerik:RadLabel id="Label2" runat="server" CssClass="c_Label2" Text="<%$ Resources: Label2 %>" />
						<asp:Button id="butDoLogin" runat="server" class="c_butDoLogin" CommandName="butDoLogin" OnClick="___butDoLogin_OnClick" TabIndex="3"
							Text="<%$ Resources: butDoLogin %>" />
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
						<telerik:RadTextBox id="txtLoginPassword" runat="server" AutoPostBack="False" CssClass="c_txtLoginPassword" EnableSingleInputRendering="True"
							MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="2" TextMode="Password" WrapperCssClass="c_txtLoginPassword_wrapper" />
						<asp:Label id="labError" runat="server" class="Error c_labError" />
						<div id="Div2" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div2">
							<asp:Label id="labProjectTitle" runat="server" class="c_labProjectTitle" Text="MCRWeb" />
						</div>
					</div>
					<telerik:RadAjaxLoadingPanel ID="___ajxMainAjaxPanel_AjaxLoading" runat="server">
					</telerik:RadAjaxLoadingPanel>
				</telerik:RadAjaxPanel>
			</div>
		</form>
		
</body>
<telerik:RadCodeBlock ID="EndCodeBlock" runat="server">
<script type="text/javascript">
	ShowClientFormulas();

	function ShowClientFormulas()
	{
	}
	var $j = jQuery.noConflict();
	$j(document).ready(SetFocusFirstField());
	function SetFocusFirstField()
	{
		try
		{
			{
				window.focus();
				setTimeout("var $j = jQuery.noConflict();$j('#txtLoginUser').first().focus();", 200);
			}
		}
		catch (e)
		{
		}
	}
</script>
</telerik:RadCodeBlock>
</html>
