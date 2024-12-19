<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="VisualizerView.aspx.cs" Inherits="MCR.VisualizerView" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head id="Head1" runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/VisualizerView.css" OrderIndex="1"/>
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
		<script language="JavaScript" type="text/javascript" src="../JS/Common.js"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Mask.js"></script>
		
	</telerik:RadCodeBlock>
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<div id="Div1" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div1">
					<div id="Div3" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div3">
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
					</div>
					<telerik:RadAjaxPanel id="AjaxPanel1" runat="server" CssClass="c_AjaxPanel1" LoadingPanelID="___AjaxPanel1_AjaxLoading">
						<asp:ListBox id="lstConsults" runat="server" CssClass="c_lstConsults" SelectionMode="Single" TabIndex="1" />
						<asp:Button id="butNew" runat="server" class="c_butNew" CommandName="butNew" OnClientClick="___butNew_OnClientClick(this);return false;"
							TabIndex="2" Text="<%$ Resources: butNew %>" />
						<asp:Button id="butDel" runat="server" class="c_butDel" CommandName="butDel" OnClick="___butDel_OnClick" TabIndex="3"
							Text="<%$ Resources: butDel %>" />
						<asp:Button id="butExecute" runat="server" class="c_butExecute" CommandName="butExecute"
							OnClientClick="___butExecute_OnClientClick(this);return false;" TabIndex="4" Text="<%$ Resources: butExecute %>" />
						<asp:Button id="butEdit" runat="server" class="c_butEdit" CommandName="butEdit" OnClientClick="___butEdit_OnClientClick(this);return false;"
							TabIndex="5" Text="<%$ Resources: butEdit %>" />
						<telerik:RadAjaxLoadingPanel ID="___AjaxPanel1_AjaxLoading" runat="server">
						</telerik:RadAjaxLoadingPanel>
					</telerik:RadAjaxPanel>
				</div>
			</div>
		</form>
 <script type="text/javascript" language="JavaScript">
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
 
	    function new_window(url) {
	        link = window.open(url, "",
"toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=600,height=600,left=40,top=50");
	    }

	    function ShowPopup(page) 
	    {
	        if ((document.getElementById("lstConsults").selectedIndex == -1) && (page != "")) {
				alert("Selecione um Item");
	        }
	        else {
	            this.location.href = "ConstructorView.aspx?" + page;
	        }
	    }

	    function New()
	    {
			ShowPopup('');
			return false;
	    }
	    function Execute()
	    {
		    if (document.getElementById("lstConsults").selectedIndex == -1) 
	        {
				alert("Selecione um Item");

	            return false;
	        }
	        else 
	        {
	            this.location.href = "ViewPage.aspx?page=" + document.getElementById("lstConsults")[document.getElementById("lstConsults").selectedIndex].value;
	        }
return false;
	    }
	    function Edit()
	    {
	    	if (document.getElementById("lstConsults").selectedIndex == -1) 
	    	{
				alert("Selecione um Item");

		    	return false;
		    }
	            ShowPopup('page=' + document.getElementById("lstConsults")[document.getElementById("lstConsults").selectedIndex].value);
			return false;

	    }
		function ___butNew_OnClientClick(sender)
		{
			New();
			return false;
		}
		function ___butExecute_OnClientClick(sender)
		{
			Execute();
			return false;
		}
		function ___butEdit_OnClientClick(sender)
		{
			Edit();
			return false;
		}
</script>
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
	function ___butNew_OnClientClick(sender)
	{
		New();
		return false;
	}
	function ___butExecute_OnClientClick(sender)
	{
		Execute();
		return false;
	}
	function ___butEdit_OnClientClick(sender)
	{
		Edit();
		return false;
	}
	</script>
</html>
