using System;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using COMPONENTS.Data;
using COMPONENTS;
using System.Data;
using COMPONENTS.Configuration;
using System.Xml;
using System.IO;
using System.Xml.Serialization;

namespace MCR
{
	public partial class ViewPage : System.Web.UI.Page
	{
		protected override void InitializeCulture()
		{
			Utility.SetThreadCulture();
		}
		protected override void OnInit(EventArgs e)
		{
			Utility.CheckAuthentication(this,true);
			if (!IsPostBack)
			{
			}
			base.OnInit(e);
		}
		
		protected void grdView_NeedDataSource(object sender, Telerik.Web.UI.GridNeedDataSourceEventArgs e)
		{
			int TotalRecords = 0;

			grdView.DataSource = GetDataGrid(grdView.CurrentPageIndex, grdView.PageSize, out TotalRecords);
			grdView.VirtualItemCount = TotalRecords;
		}

		private DataSet GetDataGrid(int CurrentPageIndex, int PageSize, out int TotalRecords)
		{
			string ViewName = HttpContext.Current.Request["page"].ToString();
			ViewSettings Sql = (ViewSettings)Deserialize(Server.MapPath("../Views/" + ViewName));
			DataAccessObject Dao = Settings.GetDataAccessObject(((COMPONENTS.Databases)HttpContext.Current.Application["Databases"])[Sql.DataBase]);

			DataCommand Select;
            DataCommand Count;

            string orderByFinal = "";
            if (grdView.MasterTableView.SortExpressions.Count > 0)
            {
                string orderBy = "";
                
                foreach (Telerik.Web.UI.GridSortExpression sort in grdView.MasterTableView.SortExpressions)
                {
                    orderBy += Dao.PoeColAspas(sort.FieldName) + " " + sort.SortOrderAsString() + ", ";
                }

                orderByFinal = orderBy.Remove(orderBy.Length - 2);
            }

            if (!String.IsNullOrEmpty(grdView.MasterTableView.FilterExpression))
            {
                if (!String.IsNullOrEmpty(orderByFinal))
                    Select = new TableCommand(Sql.GenerateSqlQuery() + " WHERE " + grdView.MasterTableView.FilterExpression + "ORDER BY " + orderByFinal, new string[0], Dao);
                else
                    Select = new TableCommand(Sql.GenerateSqlQuery() + " WHERE " + grdView.MasterTableView.FilterExpression , new string[0], Dao);

                Count = new TableCommand("SELECT COUNT(*) FROM (" + Sql.GenerateSqlQuery() + " WHERE " + grdView.MasterTableView.FilterExpression + ") t", new string[] { }, Dao);
            }
            else
            {
                if(!String.IsNullOrEmpty(orderByFinal))
                    Select = new TableCommand(Sql.GenerateSqlQuery() + " ORDER BY " + orderByFinal, new string[0], Dao);
                else
                    Select = new TableCommand(Sql.GenerateSqlQuery() , new string[0], Dao);

                Count = new TableCommand("SELECT COUNT(*) FROM (" + Sql.GenerateSqlQuery() + ") t", new string[] { }, Dao);
            }

			TotalRecords = (int)Count.ExecuteScalar();

			if (CurrentPageIndex == -1)
			{
				CurrentPageIndex = (int)Math.Ceiling((decimal)TotalRecords / (decimal)PageSize) - 1;
			}

			if (TotalRecords > 0)
			{
				return Select.Execute(CurrentPageIndex * PageSize, PageSize);
			}
			return Select.Execute();
		}

        protected void grdView_ItemCommand(object sender, Telerik.Web.UI.GridCommandEventArgs e)
        {
            Telerik.Web.UI.RadGrid Grid = (Telerik.Web.UI.RadGrid) sender;
            if (e.CommandName == Telerik.Web.UI.RadGrid.ExportToWordCommandName || e.CommandName == Telerik.Web.UI.RadGrid.ExportToPdfCommandName ||
                e.CommandName == Telerik.Web.UI.RadGrid.ExportToExcelCommandName || e.CommandName == Telerik.Web.UI.RadGrid.ExportToCsvCommandName)
            {
                Grid.AllowPaging = false;
                Grid.ExportSettings.IgnorePaging = true;
                Grid.ExportSettings.OpenInNewWindow = true;
            }
        }

		public static object Deserialize(string file)
		{
			if (!File.Exists(file)) return null;
			using (StreamReader reader = File.OpenText(file))
			{
				XmlSerializer xmlSerializer = new XmlSerializer(typeof(ViewSettings));
				return xmlSerializer.Deserialize(reader);
			}
		}
		protected override void OnLoadComplete(EventArgs e)
		{
			base.OnLoadComplete(e);
		}


	}
	
}
