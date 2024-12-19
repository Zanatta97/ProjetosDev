<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="ConfigDB.aspx.cs" Inherits="MCR.ConfigDB" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/ConfigDB.css" OrderIndex="1"/>
		</StyleSheets>
	</telerik:RadStyleSheetManager>
	<telerik:RadCodeBlock ID="CustomHeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
	<telerik:RadCodeBlock ID="HeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
</head>
<body onload="InitializeClient();" id="Form1_body" style="margin-left:auto;margin-right:auto;">
	<telerik:RadCodeBlock ID="BodyCodeBlock" runat="server">
		<script language="JavaScript" type="text/javascript" src="../JS/jquery.js" ></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
		<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/RadComboBoxHelper.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/ConfigDB_USER.js?sv=1.0_20191112113321"></script>
	</telerik:RadCodeBlock>
		
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
					<div id="Div3" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div3">
						<asp:Label id="labModuleTitle" runat="server" class="c_labModuleTitle" Text="<%$ Resources: Form1 %>" />
					</div>
					<telerik:RadAjaxPanel id="ajxAjaxPanel" runat="server" CssClass="c_ajxAjaxPanel" LoadingPanelID="___ajxAjaxPanel_AjaxLoading">
						<telerik:RadTextBox id="txtServer" runat="server" AutoPostBack="False" CssClass="c_txtServer" EnableSingleInputRendering="True" MaxLength="0"
							ReadOnly="False" RenderMode="Classic" TabIndex="1" TextMode="SingleLine" WrapperCssClass="c_txtServer_wrapper" />
						<telerik:RadTextBox id="txtDataBase" runat="server" AutoPostBack="False" CssClass="c_txtDataBase" EnableSingleInputRendering="True"
							MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="2" TextMode="SingleLine" WrapperCssClass="c_txtDataBase_wrapper" />
						<telerik:RadCheckBox id="chkAutent" runat="server" AutoPostBack="True" Checked="False" CssClass="chkAutent c_chkAutent"
							OnCheckedChanged="___chkAutent_OnCheckedChanged" RenderMode="Classic" TabIndex="3" Text="<%$ Resources: chkAutent %>" />
						<telerik:RadTextBox id="txtUser" runat="server" AutoPostBack="False" CssClass="c_txtUser" EnableSingleInputRendering="True" MaxLength="0"
							ReadOnly="False" RenderMode="Classic" TabIndex="4" TextMode="SingleLine" WrapperCssClass="c_txtUser_wrapper" />
						<telerik:RadTextBox id="txtPassword" runat="server" AutoPostBack="False" CssClass="c_txtPassword" EnableSingleInputRendering="True"
							MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="5" TextMode="Password" WrapperCssClass="c_txtPassword_wrapper" />
						<telerik:RadComboBox id="cboDataType" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboDataType"
							CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
							ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboDataType %>" MarkFirstMatch="true" MaxHeight="100"
							OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic" TabIndex="6" />
						<telerik:RadTextBox id="txtProvider" runat="server" AutoPostBack="False" CssClass="c_txtProvider" EnableSingleInputRendering="True"
							MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="7" TextMode="SingleLine" WrapperCssClass="c_txtProvider_wrapper" />
						<telerik:RadLabel id="Label2" runat="server" CssClass="c_Label2" Text="<%$ Resources: Label2 %>" />
						<telerik:RadLabel id="lbDbName" runat="server" CssClass="c_lbDbName" Text="<%$ Resources: lbDbName %>" />
						<telerik:RadLabel id="labPassword" runat="server" CssClass="c_labPassword" Text="<%$ Resources: labPassword %>" />
						<telerik:RadLabel id="labUser" runat="server" CssClass="c_labUser" Text="<%$ Resources: labUser %>" />
						<telerik:RadLabel id="Label7" runat="server" CssClass="c_Label7" Text="<%$ Resources: Label7 %>" />
						<telerik:RadLabel id="Label9" runat="server" CssClass="c_Label9" Text="<%$ Resources: Label9 %>" />
						<telerik:RadAjaxLoadingPanel ID="___ajxAjaxPanel_AjaxLoading" runat="server">
						</telerik:RadAjaxLoadingPanel>
					</telerik:RadAjaxPanel>
					<asp:Button id="butCreate" runat="server" class="c_butCreate" CommandName="butCreate" OnClick="___butCreate_OnClick" TabIndex="8"
						Text="<%$ Resources: butCreate %>" />
					<asp:Label id="labError" runat="server" class="Error c_labError" />
				</div>
			</div>
		</form>
</body>
<telerik:RadCodeBlock ID="EndCodeBlock" runat="server">
	<script type="text/javascript">
		currentPath = "<%= Page.Request.Path %>";
		function OnLoginSucceded()
		{
			if(getParentPage() != self && getParentPage() != null)
			{
				getParentPage().OnLoginSucceded();
			}
		}
		function TryLogin(PageToRedirect, RefreshControlsID)
		{
			TryParentLogin(PageToRedirect, RefreshControlsID, false, '<%= ResolveUrl("~/Pages/StartPage.aspx") %>');
		}
		var $j = jQuery.noConflict();
		$j(document).ready(SetFocusFirstField());
		function SetFocusFirstField()
		{
			try
			{
				{
					window.focus();
					setTimeout("var $j = jQuery.noConflict();$j('#txtServer').first().focus();", 200);
				}
			}
			catch (e)
			{
			}
		}
		function AutenticacaoWindows() { return AutenticacaoWindows.checked; }
		function ___txtServer_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		function ___txtDataBase_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		function ___txtUser_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		function ___txtProvider_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		function ___txtPassword_onkeydown(event,vgWin)
		{
			onTextChanged(event);
		}
		try
		{
			if(getParentPage() != self)
			{
				getParentPage().EnableButtons();
			}
		}
		catch (e)
		{
		}
		document.getElementById('txtPassword').value = document.getElementById('txtPassword').getAttribute('DefaultPassword');
	</script>
</telerik:RadCodeBlock>
</html>
