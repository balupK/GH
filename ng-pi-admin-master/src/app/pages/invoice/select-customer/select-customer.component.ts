import { Component, OnInit,  Input, Output , EventEmitter} from '@angular/core';
import { UserProfileService } from '../../../services/userProfile.service';

@Component({
  selector: 'app-select-customer',
  templateUrl: './select-customer.component.html',
  styleUrls: ['./select-customer.component.scss']
})
export class SelectCustomerComponent implements OnInit {

  customerData: any;

  private customerExists;

  rows: any = [];

  temp = [];

  public columns:Array<any> = [
    { name: 'Name' , value: 'name', type: 'link'},
    { name: 'Position',value: 'position'},
    { name: 'Shop Name',value: 'shopName'},
    { name: 'Email',value: 'email'},
    { name: 'State',value: 'state'},
    { name: 'Mobile',value: 'mobile'}
  ];

  public page:number = 1;
  public itemsPerPage:number = 10;
  public maxSize:number = 5;
  public numPages:number = 1;
  public length:number = 0;

  public config:any = {
    paging: true,
    sorting: {columns: this.columns},
    filtering: {filterString: ''},
    className: ['table-striped', 'table-bordered']
  };



  constructor(private userProfileService:UserProfileService) { }

  ngOnInit() {
    this.loadData();
  }

  //@Input('isCustomerSelected')
  //isCustomerSelected: boolean ;

  get isCustomerSelected() : boolean {
    return this.customerExists;
  }

  @Input()
  set isCustomerSelected (val : boolean) {
    this.customerExists = val;
  }

  @Output()
  customer = new EventEmitter();


  loadData() {
    this.userProfileService.getUserProfile().subscribe(resp => {
    console.log(resp);
    this.rows = resp;
    
    // this.temp = JSON.parse(JSON.stringify(resp));
    });
  }

  gotoInvoicePage(customerObject : any){

    console.log(customerObject);
    this.customer.emit(customerObject);

  }

  displayInvoice(customer) {
    console.log(customer);
    this.customer.emit(customer);
    
  }

  updateFilter(event) {
    const val = event.target.value.toLowerCase();

    // filter our data
    const temp = this.temp.filter(function(d) {
      return d.name.toLowerCase().indexOf(val) !== -1 || !val;
    });

    // update the rows
    this.rows = temp;
    // Whenever the filter changes, always go back to the first page
  }

}
