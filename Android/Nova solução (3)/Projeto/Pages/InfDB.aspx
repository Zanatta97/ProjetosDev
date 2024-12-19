<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="InfDB.aspx.cs" Inherits="MCR.InfDB" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
	<head runat="server">
		<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/InfDB.css" OrderIndex="1"/>
		</StyleSheets>
	</telerik:RadStyleSheetManager>
	<telerik:RadCodeBlock ID="CustomHeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
	</head>
	<body onload="InitializeClient();" id="Form1_body" style="margin-left:auto;margin-right:auto;">
		<telerik:RadCodeBlock ID="BodyCodeBlock" runat="server">
			<script language="JavaScript" type="text/javascript" src="../JS/jquery.js" ></script>
			<script language="JavaScript" type="text/javascript" src="../JS/InfDB_USER.js"></script>
			<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
			<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
			<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>
		</telerik:RadCodeBlock>
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
		</script>
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
					<div id="Div3" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div3">
						<asp:Label id="labModuleTitle" runat="server" class="c_labModuleTitle" Text="<%$ Resources: Form1 %>" />
					</div>
					<telerik:RadAjaxPanel id="AjaxPanel" runat="server" CssClass="c_AjaxPanel" LoadingPanelID="___AjaxPanel_AjaxLoading">
						<asp:Panel id="Panel1" runat="server" BorderStyle="Solid" BorderWidth="1" class="c_Panel1" ScrollBars="Auto">
							<telerik:RadTreeView id="trvDataBase" runat="server" CssClass="c_trvDataBase" RenderMode="Classic">
							</telerik:RadTreeView>
						</asp:Panel>
						<telerik:RadCheckBox id="chkIntegrity" runat="server" AutoPostBack="True" Checked="False" CssClass="chkIntegrity c_chkIntegrity"
							OnCheckedChanged="___chkIntegrity_OnCheckedChanged" RenderMode="Classic" TabIndex="2" Text="<%$ Resources: chkIntegrity %>" />
						<telerik:RadAjaxLoadingPanel ID="___AjaxPanel_AjaxLoading" runat="server">
						</telerik:RadAjaxLoadingPanel>
					</telerik:RadAjaxPanel>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
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
	</script>
	
</html>
