<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="Filtro.aspx.cs" Inherits="MCR.Filtro" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head id="Head1" runat="server">
    <title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/Filtro.css" OrderIndex="1"/>
		</StyleSheets>
	</telerik:RadStyleSheetManager>
	<telerik:RadCodeBlock ID="CustomHeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
	<telerik:RadCodeBlock ID="HeaderCodeBlock" runat="server">
	</telerik:RadCodeBlock>
</head>
<body onload="InitializeClient();" id="Form1_body" style="margin-left:auto;margin-right:auto;">
	<script language="JavaScript" type="text/javascript" src="../JS/jquery.js" ></script>
	<script language="JavaScript" type="text/javascript" src="../JS/Page.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/Filtro_USER.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
	<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/RadComboBoxHelper.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/Extensions.js"></script>
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
		function ExecFilter() 
		{
			var url = document.referrer;
			if (typeof (url) == "undefinied" || url == "") 
			{
				SetFilter(document.getElementById(ExpressionFieldName).value);
				vgWin.Close();
			}
			else 
			{
				var RealUrl = url;
				var index = url.toString().indexOf("sessionfilter");
				if (index != -1) 
				{
					RealUrl = url.substring(0, index);
				}
				location.href = RealUrl + ((RealUrl.indexOf("?") != -1) ? "&" : "?") + "sessionfilter=" + document.getElementById("__SESSIONFILTER").value;
			}
		}

		function Load() 
		{
			if (this.parent.GetCurrentFilter() == null) 
			{
				document.getElementById(ExpressionFieldName).value = "";
			}
			else 
			{
				document.getElementById(ExpressionFieldName).value = this.parent.GetCurrentFilter();
			}
		}
	</script>
		
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<telerik:RadAjaxPanel id="ajxMainAjaxPanel" runat="server" CssClass="c_ajxMainAjaxPanel" LoadingPanelID="___ajxMainAjaxPanel_AjaxLoading">
					<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
						<telerik:RadComboBox id="cboField" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboField"
							CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
							ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboField %>" MarkFirstMatch="true" MaxHeight="100"
							OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic" TabIndex="1" />
						<telerik:RadComboBox id="cboOperator" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboOperator"
							CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
							ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboOperator %>" MarkFirstMatch="true" MaxHeight="100"
							OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic" TabIndex="2" />
						<telerik:RadTextBox id="txtValue" runat="server" AutoPostBack="False" CssClass="c_txtValue" EnableSingleInputRendering="True"
							ForeColor="#000000" MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="4" TextMode="SingleLine" WrapperCssClass="c_txtValue_wrapper"
							/>
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
						<telerik:RadLabel id="Label2" runat="server" CssClass="c_Label2" Text="<%$ Resources: Label2 %>" />
						<telerik:RadLabel id="Label3" runat="server" CssClass="c_Label3" Text="<%$ Resources: Label3 %>" />
						<telerik:RadDatePicker id="FieldDate" runat="server" CssClass="c_FieldDate" ClientEvents-OnDateSelected="setDatePickerFocus"
							DatePickerType="Date" DatePopupButton-ToolTip="Select date" EnableEmbeddedSkins="True" HideAnimation-Duration="300" HideAnimation-Type="Fade"
							MinDate="01/01/1900" PopupDirection="BottomRight" ReadOnly="False" RenderMode="Classic" ShowAnimation-Duration="300" ShowAnimation-Type="Fade"
							TabIndex="3" Width="201px">
						</telerik:RadDatePicker>
					</div>
					<asp:RadioButton id="rdAnd" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False" class="rdAnd c_rdAnd"
						GroupName="ajxMainAjaxPanelGroup" TabIndex="5" Text="<%$ Resources: rdAnd %>" />
					<asp:RadioButton id="rdOr" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False" class="rdOr c_rdOr"
						GroupName="ajxMainAjaxPanelGroup" TabIndex="6" Text="<%$ Resources: rdOr %>" />
					<asp:Button id="butConcatenate" runat="server" class="c_butConcatenate" CommandName="butConcatenate" OnClick="___butConcatenate_OnClick"
						TabIndex="7" Text="<%$ Resources: butConcatenate %>" />
					<telerik:RadTextBox id="txtExpression" runat="server" AutoPostBack="False" CssClass="c_txtExpression" EnableSingleInputRendering="True"
						ForeColor="#000000" MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="8" TextMode="MultiLine"
						WrapperCssClass="c_txtExpression_wrapper" />
					<asp:Button id="butExecuteFilter" runat="server" class="c_butExecuteFilter" CommandName="butExecuteFilter" OnClick="___butExecuteFilter_OnClick"
						TabIndex="9" Text="<%$ Resources: butExecuteFilter %>" />
					<asp:Button id="butClearFilter" runat="server" class="c_butClearFilter" CommandName="butClearFilter" OnClick="___butClearFilter_OnClick"
						TabIndex="10" Text="<%$ Resources: butClearFilter %>" />
					<telerik:RadAjaxLoadingPanel ID="___ajxMainAjaxPanel_AjaxLoading" runat="server">
					</telerik:RadAjaxLoadingPanel>
				</telerik:RadAjaxPanel>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		function ___txtExpression_onkeydown(event,vgWin)
		{
		}
		function ___txtValue_onkeydown(event,vgWin)
		{
		}
		function cboCampo() { return $find("<%= cboField.ClientID %>").get_value(); }
		function cboOperador() { return $find("<%= cboOperator.ClientID %>").get_value(); }
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
