<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" ValidateRequest="false" CodeFile="ErrorPage.aspx.cs" Inherits="MCR.ErrorPage" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/ErrorPage.css" OrderIndex="1"/>
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
			<script language="JavaScript" type="text/javascript" src="../JS/ErrorPage_USER.js?sv=1.0_20191112113320"></script>
		<script type="text/javascript">
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
			currentPath = "<%= Page.Request.Path %>";
		</script>
	</telerik:RadCodeBlock>
		
	<script type="text/javascript">
	</script>
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<telerik:RadAjaxPanel id="AjaxPanel1" runat="server" CssClass="c_AjaxPanel1" LoadingPanelID="___AjaxPanel1_AjaxLoading">
					<asp:Image id="Image1" runat="server" class="c_Image1" ImageUrl="../Images/AspxModule/Error.png" />
					<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
						<telerik:RadLabel id="Label4" runat="server" CssClass="c_Label4" Text="<%$ Resources: Label4 %>" />
						<div id="Div2" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div2">
							<telerik:RadLabel id="Label2" runat="server" CssClass="c_Label2" Text="<%$ Resources: Label2 %>" />
							<telerik:RadLabel id="Label3" runat="server" CssClass="c_Label3" Text="<%$ Resources: Label3 %>" />
							<asp:Label id="labHttpErrorCode" runat="server" class="c_labHttpErrorCode" Text="HTTP ERROR CODE" />
							<asp:Label id="labHttpErrorMessage" runat="server" class="c_labHttpErrorMessage" Text="HTTP ERROR Message" />
						</div>
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
					</div>
					<telerik:RadAjaxLoadingPanel ID="___AjaxPanel1_AjaxLoading" runat="server">
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
</script>
</telerik:RadCodeBlock>
</html>
