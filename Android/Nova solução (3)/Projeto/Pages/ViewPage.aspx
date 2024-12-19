<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="ViewPage.aspx.cs" Inherits="MCR.ViewPage" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head id="Head1" runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/ViewPage.css" OrderIndex="1"/>
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
		<script language="JavaScript" src='../JS/Functions.js' type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
		<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>
	</telerik:RadCodeBlock>
		
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="False">
				<div id="Div1" runat="server" autoexpandtocontent="True" autoexpandtocontentmargin="10" class="c_Div1">
					<div id="Div4" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div4">
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
					</div>
					<telerik:RadAjaxPanel id="AjaxPanel1" runat="server" CssClass="c_AjaxPanel1" ClientEvents-OnRequestStart="___AjaxPanel1_OnRequestStart"
						ClientEvents-OnResponseEnd="___AjaxPanel1_OnResponseEnd" LoadingPanelID="___AjaxPanel1_AjaxLoading">
						<telerik:RadGrid id="grdView" runat="server" AllowCustomPaging="true" AllowFilteringByColumn="False" AllowPaging="True" AllowSorting="True"
							AutoGenerateColumns="true" CssClass="c_grdView" EnableLinqExpressions="false" OnItemCommand="grdView_ItemCommand"
							OnNeedDataSource="grdView_NeedDataSource" PageSize="10" RenderMode="Classic" ShowGroupPanel="False" TabIndex="1" TableLayout="Fixed">
							<MasterTableView  AllowCustomPaging="true" CommandItemDisplay="Top" EditMode="InPlace">
								<EditFormSettings>
									<EditColumn FilterControlAltText="Filter EditCommandColumn column">
									</EditColumn>
								</EditFormSettings>
								<CommandItemSettings ShowAddNewRecordButton="False" AddNewRecordText="" RefreshText="" />
							</MasterTableView>
							<PagerStyle Mode="NextPrevAndNumeric" />
							<ClientSettings AllowKeyboardNavigation="true">
								<ClientEvents />
							</ClientSettings>
						</telerik:RadGrid>
						<telerik:RadAjaxLoadingPanel ID="___AjaxPanel1_AjaxLoading" runat="server">
						</telerik:RadAjaxLoadingPanel>
					</telerik:RadAjaxPanel>
					<asp:Label id="Label21" runat="server" class="Error c_Label21" />
				</div>
			</div>
		</form>
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
	function ___AjaxPanel1_OnResponseEnd(sender, args)
	{
		OnResponseEnd(sender,args);
	}
	function ___AjaxPanel1_OnRequestStart(sender, args)
	{
		OnRequestStart(sender,args);
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
</script>
</body>
</html>
