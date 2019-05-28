import { Component, OnInit ,Input, Output , EventEmitter} from '@angular/core';
import { TablesDataService } from './tablesData.service';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss'],
  providers: [TablesDataService]
})
export class DataTableComponent implements OnInit {
  tableData: Array<any>;

  /* pagination Info */
  pageSize = 10;
  pageNumber = 1;
  @Input() columns: Array<any> = [];
  @Input() rows: Array<any> = [];

  @Output()
  customer = new EventEmitter();

  constructor(private _tablesDataService: TablesDataService) { }

  ngOnInit() {
    //  this.loadData();
     console.log("columns",this.columns)
    //  this.columns = [{name :'FIRSTNAME', value : 'firstName'},
    //  {name :'LASTNAME', value : 'lastName'},
    //  {name :'USERNAME', value : 'username'},
    //  {name :'EMAIL', value : 'email'},
    //  {name :'AGE', value : 'age'}]
  }

  loadData() {
    this.tableData = this._tablesDataService.DATA;
  }

  pageChanged(pN: number): void {
    this.pageNumber = pN;
  }

  gotoInvoicePage(customerObject : any){

    console.log(customerObject)
    this.customer.emit(customerObject);

  }
}
