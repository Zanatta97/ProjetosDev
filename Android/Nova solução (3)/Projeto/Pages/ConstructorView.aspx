<%@ Page Language="C#" AutoEventWireup="true" EnableEventValidation="True" CodeFile="ConstructorView.aspx.cs" Inherits="MCR.ConstructorView" Culture="auto" UICulture="auto"%>
<%@ Register Assembly="Telerik.Web.UI" Namespace="Telerik.Web.UI" TagPrefix="telerik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=MCR.Utility.CurrentSiteLanguage%>">
<head runat="server">
	<title><asp:Literal runat="server" Text="<%$ Resources: Form1 %>" /></title>
	<telerik:RadStyleSheetManager runat="server" ID="styleSheetManager">
		<StyleSheets>
			<telerik:StyleSheetReference Path="~/Styles/ConstructorView.css" OrderIndex="1"/>
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
		<script language="JavaScript" type="text/javascript" src="../JS/Page.js"></script>
		<script language="JavaScript" type="text/javascript" src="../JS/Functions.js"></script>
		<script language="JavaScript" src='../JS/Mask.js' type="text/javascript"></script>	
		<script language="JavaScript" type="text/javascript" src="../JS/RadComboBoxHelper.js"></script>
	<script language="JavaScript" type="text/javascript" src="../JS/ConstructorView_USER.js?sv=1.0_20191112113321"></script>
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
    <script type="text/javascript">
        //cmbQueryName
        function txtQueryChanged() 
		{
            if (document.getElementById(ControlsPanel).disabled == false) 
			{
                Default.Gasconfirm("Ao editar a query manualmente o editor será desabilitado. Deseja continuar?", CallBack);
                function CallBack(retval) 
				{
                    if (retval) 
					{
                        ExecuteCommandRequest('SetCustomView');
                    }
                    else 
					{
                        ExecuteCommandRequest('SetManagedView');
                    }
                }
            }
        }
		function ___txtViews_onkeydown(event,vgWin)
		{
		}
		function ___txtQuery_onkeydown(event,vgWin)
		{
		}
		function ___txtColumnTitle_onkeydown(event,vgWin)
		{
		}
		function ___txtTopRegisters_onkeydown(event,vgWin)
		{
		}
		function ___txtJoinAlias_onkeydown(event,vgWin)
		{
		}
    </script>
		
		<form id="Form1" runat="server" class="c_Form1">
			<asp:ScriptManager ID="MainScriptManager" runat="server"/>
			<div id="__MainDiv" class="c_MainDiv" FitToContent="True" MarginToContent="0">
				<div id="Div1" runat="server" autoexpandtocontent="True" autoexpandtocontentmargin="10" class="c_Div1">
					<div id="Div5" runat="server" autoexpandtocontent="False" autoexpandtocontentmargin="10" class="c_Div5">
						<telerik:RadLabel id="Label24" runat="server" CssClass="c_Label24" Text="<%$ Resources: Label24 %>" />
					</div>
					<telerik:RadAjaxPanel id="ControlsAjaxPanel" runat="server" CssClass="c_ControlsAjaxPanel" LoadingPanelID="___ControlsAjaxPanel_AjaxLoading">
						<telerik:RadLabel id="Label1" runat="server" CssClass="c_Label1" Text="<%$ Resources: Label1 %>" />
						<telerik:RadTextBox id="txtViews" runat="server" AutoPostBack="False" CssClass="c_txtViews" EnableSingleInputRendering="True" MaxLength="0"
							ReadOnly="False" RenderMode="Classic" TabIndex="1" TextMode="SingleLine" WrapperCssClass="c_txtViews_wrapper" />
						<telerik:RadComboBox id="cboDbs" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboDbs"
							CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
							ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboDbs %>" MarkFirstMatch="true" MaxHeight="100"
							OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic" TabIndex="2" />
						<telerik:RadLabel id="Label2" runat="server" CssClass="c_Label2" Text="<%$ Resources: Label2 %>" />
						<telerik:RadLabel id="Label23" runat="server" CssClass="c_Label23" />
						<telerik:RadTextBox id="txtQuery" runat="server" AutoPostBack="False" CssClass="c_txtQuery" EnableSingleInputRendering="True"
							ForeColor="#000000" MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="44" TextMode="MultiLine" WrapperCssClass="c_txtQuery_wrapper"
							/>
						<asp:Panel id="ControlsPanel" runat="server" BorderStyle="None" BorderWidth="0" class="c_ControlsPanel" ScrollBars="Auto">
							<div style="position:absolute !important;left:0px;top:0px;width:650px;height:344px">
								<telerik:RadTabStrip id="TabControl1" runat="server" Align="Left" AutoPostBack="True" CssClass="c_TabControl1"
									MultiPageID="TabControl1MultiPage" PerTabScrolling="False" RenderMode="Classic" ScrollButtonsPosition="Middle" ScrollChildren="True">
									<Tabs>
										<telerik:RadTab id="TabItem1" runat="server" CssClass="c_TabItem1" Selected="true" Text="<%$ Resources: TabPage1 %>">
										</telerik:RadTab>
										<telerik:RadTab id="TabItem2" runat="server" CssClass="c_TabItem2" Text="<%$ Resources: TabPage2 %>">
										</telerik:RadTab>
										<telerik:RadTab id="TabItem3" runat="server" CssClass="c_TabItem3" Text="<%$ Resources: TabPage3 %>">
										</telerik:RadTab>
									</Tabs>
								</telerik:RadTabStrip>
								<telerik:RadMultiPage runat="server" ID="TabControl1MultiPage" BorderColor="#000000" BorderWidth="1" BorderStyle="Solid" Width="100%" Height="318px" SelectedIndex="0">
									<telerik:RadPageView id="TabPage1" runat="server" BackColor="#FFFFFF" CssClass="c_TabPage1">
										<asp:ListBox id="lstTables" runat="server" CssClass="c_lstTables" SelectionMode="Single" TabIndex="3" />
										<telerik:RadLabel id="Label3" runat="server" CssClass="c_Label3" Text="<%$ Resources: Label3 %>" />
										<telerik:RadLabel id="Label4" runat="server" CssClass="c_Label4" Text="<%$ Resources: Label4 %>" />
										<asp:ListBox id="lstFields" runat="server" CssClass="c_lstFields" SelectionMode="Single" TabIndex="5" />
										<asp:Button id="butAddField" runat="server" class="c_butAddField" CommandName="butAddField" OnClick="___butAddField_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="6" />
										<asp:Button id="butDelField" runat="server" class="c_butDelField" CommandName="butDelField" OnClick="___butDelField_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="7" />
										<telerik:RadLabel id="Label22" runat="server" CssClass="c_Label22" Text="<%$ Resources: Label22 %>" />
										<asp:ListBox id="lstSelectedField" runat="server" CssClass="c_lstSelectedField" SelectionMode="Single" TabIndex="8" />
										<asp:Button id="butUpField" runat="server" class="c_butUpField" CommandName="butUpField" OnClick="___butUpField_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="9" />
										<asp:Button id="butDownField" runat="server" class="c_butDownField" CommandName="butDownField" OnClick="___butDownField_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="10" />
										<telerik:RadLabel id="Label5" runat="server" CssClass="c_Label5" Text="<%$ Resources: Label5 %>" />
										<telerik:RadLabel id="Label6" runat="server" CssClass="c_Label6" Text="<%$ Resources: Label6 %>" />
										<telerik:RadLabel id="Label7" runat="server" CssClass="c_Label7" Text="<%$ Resources: Label7 %>" />
										<telerik:RadComboBox id="cboColumnContent" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboColumnContent"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboColumnContent %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="12" />
										<telerik:RadComboBox id="cboColumnFunc" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboColumnFunc"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboColumnFunc %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="11" />
										<telerik:RadTextBox id="txtColumnTitle" runat="server" AutoPostBack="False" CssClass="c_txtColumnTitle" EnableSingleInputRendering="True"
											ForeColor="#000000" MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="13" TextMode="SingleLine"
											WrapperCssClass="c_txtColumnTitle_wrapper" />
										<asp:Button id="butNewCol" runat="server" class="c_butNewCol" CommandName="butNewCol" OnClick="___butNewCol_OnClick" TabIndex="14"
											Text="<%$ Resources: butNewCol %>" />
										<asp:Button id="butDelJoin" runat="server" class="c_butDelJoin" CommandName="butDelJoin" OnClick="___butDelJoin_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="4" />
									</telerik:RadPageView>
									<telerik:RadPageView id="TabPage2" runat="server" BackColor="#FFFFFF" CssClass="c_TabPage2">
										<asp:ListBox id="lstGroup" runat="server" CssClass="c_lstGroup" SelectionMode="Single" TabIndex="15" />
										<telerik:RadLabel id="Label8" runat="server" CssClass="c_Label8" Text="<%$ Resources: Label8 %>" />
										<telerik:RadLabel id="Label9" runat="server" CssClass="c_Label9" Text="<%$ Resources: Label9 %>" />
										<asp:ListBox id="lstOrder" runat="server" CssClass="c_lstOrder" SelectionMode="Single" TabIndex="21" />
										<asp:ListBox id="lstSelectedGroupBy" runat="server" CssClass="c_lstSelectedGroupBy" SelectionMode="Single" TabIndex="18" />
										<telerik:RadLabel id="Label10" runat="server" CssClass="c_Label10" Text="<%$ Resources: Label10 %>" />
										<telerik:RadLabel id="Label11" runat="server" CssClass="c_Label11" Text="<%$ Resources: Label11 %>" />
										<asp:ListBox id="lstSelectedOrderBy" runat="server" CssClass="c_lstSelectedOrderBy" SelectionMode="Single" TabIndex="24" />
										<asp:RadioButton id="rdbAsc" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False" class="rdbAsc c_rdbAsc"
											GroupName="TabPage2Group" TabIndex="27" Text="<%$ Resources: rdbAsc %>" />
										<asp:Button id="butUpOrderBy" runat="server" class="c_butUpOrderBy" CommandName="butUpOrderBy" OnClick="___butUpOrderBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="25" />
										<asp:Button id="butDownGroupBy" runat="server" class="c_butDownGroupBy" CommandName="butDownGroupBy" OnClick="___butDownGroupBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="20" />
										<asp:Button id="butUpGroupBy" runat="server" class="c_butUpGroupBy" CommandName="butUpGroupBy" OnClick="___butUpGroupBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="19" />
										<asp:Button id="butDownOrderBy" runat="server" class="c_butDownOrderBy" CommandName="butDownOrderBy" OnClick="___butDownOrderBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="26" />
										<asp:RadioButton id="rdbDesc" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False"
											class="rdbDesc c_rdbDesc" GroupName="TabPage2Group" TabIndex="28" Text="<%$ Resources: rdbDesc %>" />
										<asp:Button id="butDelGroupBy" runat="server" class="c_butDelGroupBy" CommandName="butDelGroupBy" OnClick="___butDelGroupBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="17" />
										<asp:Button id="butDelOrderBy" runat="server" class="c_butDelOrderBy" CommandName="butDelOrderBy" OnClick="___butDelOrderBy_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="23" />
										<asp:Button id="butAddGroup" runat="server" class="c_butAddGroup" CommandName="butAddGroup" OnClick="___butAddGroup_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="16" />
										<asp:Button id="butAddOrder" runat="server" class="c_butAddOrder" CommandName="butAddOrder" OnClick="___butAddOrder_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="22" />
									</telerik:RadPageView>
									<telerik:RadPageView id="TabPage3" runat="server" BackColor="#FFFFFF" CssClass="c_TabPage3">
										<telerik:RadTextBox id="txtTopRegisters" runat="server" AutoPostBack="False" CssClass="c_txtTopRegisters" EnableSingleInputRendering="True"
											MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="29" TextMode="SingleLine" WrapperCssClass="c_txtTopRegisters_wrapper" />
										<telerik:RadLabel id="Label12" runat="server" CssClass="c_Label12" Text="<%$ Resources: Label12 %>" />
										<telerik:RadComboBox id="cboJoinType" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboJoinType"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboJoinType %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="30" />
										<telerik:RadLabel id="Label14" runat="server" CssClass="c_Label14" Text="<%$ Resources: Label14 %>" />
										<telerik:RadComboBox id="cboJoinTable" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboJoinTable"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboJoinTable %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="33" />
										<telerik:RadComboBox id="cboJoinField" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboJoinField"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboJoinField %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="31" />
										<telerik:RadComboBox id="cboJoinOperator" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboJoinOperator"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboJoinOperator %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="34" />
										<telerik:RadComboBox id="cboJoinBaseField" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboJoinBaseField"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboJoinBaseField %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="32" />
										<telerik:RadLabel id="Label15" runat="server" CssClass="c_Label15" Text="<%$ Resources: Label15 %>" />
										<telerik:RadLabel id="Label16" runat="server" CssClass="c_Label16" Text="<%$ Resources: Label16 %>" />
										<telerik:RadLabel id="Label17" runat="server" CssClass="c_Label17" Text="<%$ Resources: Label17 %>" />
										<telerik:RadLabel id="Label13" runat="server" CssClass="c_Label13" Text="<%$ Resources: Label13 %>" />
										<asp:Button id="butAddJoin" runat="server" class="c_butAddJoin" CommandName="butAddJoin" OnClick="___butAddJoin_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="36" />
										<telerik:RadLabel id="Label18" runat="server" CssClass="c_Label18" Text="<%$ Resources: Label18 %>" />
										<telerik:RadTextBox id="txtJoinAlias" runat="server" AutoPostBack="False" CssClass="c_txtJoinAlias" EnableSingleInputRendering="True"
											MaxLength="0" ReadOnly="False" RenderMode="Classic" TabIndex="35" TextMode="SingleLine" WrapperCssClass="c_txtJoinAlias_wrapper" />
										<telerik:RadLabel id="Label26" runat="server" CssClass="c_Label26" Text="<%$ Resources: Label26 %>" />
										<telerik:RadComboBox id="cboField" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboField"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboField %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="37" />
										<telerik:RadComboBox id="cboOperator" runat="server" AllowCustomText="False" AutoPostBack="False" CssClass="c_cboOperator"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboOperator %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="38" />
										<telerik:RadLabel id="Label20" runat="server" CssClass="c_Label20" Text="<%$ Resources: Label20 %>" />
										<telerik:RadComboBox id="cboValue" runat="server" AllowCustomText="True" AutoPostBack="False" CssClass="c_cboValue"
											CollapseAnimation-Duration="300" CollapseAnimation-Type="None" EnableEmbeddedSkins="True" EnableVirtualScrolling="True"
											ExpandAnimation-Duration="300" ExpandAnimation-Type="None" LoadingMessage="<%$ Resources: cboValue %>" MarkFirstMatch="true"
											MaxHeight="100" OnClientItemsRequesting="Combo_OnClientItemsRequesting" OnClientKeyPressing="Combo_HandleKeyPress" RenderMode="Classic"
											TabIndex="39" />
										<telerik:RadLabel id="Label21" runat="server" CssClass="c_Label21" Text="<%$ Resources: Label21 %>" />
										<asp:RadioButton id="rdbAnd" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False" class="rdbAnd c_rdbAnd"
											GroupName="TabPage3Group" TabIndex="40" Text="<%$ Resources: rdbAnd %>" />
										<asp:RadioButton id="rdbOr" runat="server" AutoPostBack="false" BorderStyle="None" BorderWidth="0" Checked="False" class="rdbOr c_rdbOr"
											GroupName="TabPage3Group" TabIndex="41" Text="<%$ Resources: rdbOr %>" />
										<asp:Button id="butAddFilter" runat="server" class="c_butAddFilter" CommandName="butAddFilter" OnClick="___butAddFilter_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="42" />
										<asp:Button id="butClearFilter" runat="server" class="c_butClearFilter" CommandName="butClearFilter" OnClick="___butClearFilter_OnClick"
											OnClientClick="this.disabled = true;" TabIndex="43" />
										<telerik:RadLabel id="Label19" runat="server" CssClass="c_Label19" Text="<%$ Resources: Label19 %>" />
										<telerik:RadLabel id="Label25" runat="server" CssClass="c_Label25" Text="<%$ Resources: Label25 %>" />
										<Div id="Line1" class="c_Line1">
										</Div>
									</telerik:RadPageView>
								</telerik:RadMultiPage>
							</div>
						</asp:Panel>
						<asp:Button id="butSave" runat="server" class="c_butSave" CommandName="butSave" OnClick="___butSave_OnClick" TabIndex="46"
							Text="<%$ Resources: butSave %>" />
						<asp:Button id="butTest" runat="server" class="c_butTest" CommandName="butTest" OnClick="___butTest_OnClick" TabIndex="45"
							Text="<%$ Resources: butTest %>" />
						<telerik:RadLabel id="ResultLabel" runat="server" CssClass="c_ResultLabel" />
						<telerik:RadAjaxLoadingPanel ID="___ControlsAjaxPanel_AjaxLoading" runat="server">
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
	function ___txtViews_onkeydown(event,vgWin)
	{
	}
	function ___txtQuery_onkeydown(event,vgWin)
	{
	}
	function ___txtColumnTitle_onkeydown(event,vgWin)
	{
	}
	function ___txtTopRegisters_onkeydown(event,vgWin)
	{
	}
	function ___txtJoinAlias_onkeydown(event,vgWin)
	{
	}
	</script>

</html>
