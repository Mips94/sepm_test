import { Component, OnInit } from '@angular/core';
import {LocationServiceService} from '../../services/location.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '../../dtos/location';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.scss']
})
export class LocationListComponent implements OnInit {
  locations: Location[] = [];
  error: string | null =  '';
  defaultImageLocation = '../assets/unknown_picture.png';

  constructor(
    private service: LocationServiceService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    //this.getNextLocations();
    this.getTestData();
  }

  getNextLocations(): void {
    this.service.getLocations().subscribe({
      next: data => {
        console.log('received locations', data);
        this.locations = this.locations.concat(data);
      },
      error: error => {
        console.error('Error fetching locations', error.message);
        this.showError('Could not fetch locations: ' + error.message);
      }
    });
  }

  getTestData(): void {
    const testArr: Array<Location> = [
      new Location(1, 'Bar 1'),
      new Location(2, 'Bar 2'),
      new Location(3, 'Museum AB'),
      new Location(4, 'Museum XY'),
      new Location(5, 'Test 5')
    ];
    console.log(testArr);
    console.log(this.locations);
    this.locations = this.locations.concat(testArr);
    console.log(this.locations);
  }

  public vanishError(): void {
    this.error = null;
  }

  private showError(msg: string) {
    this.error = msg;
  }


}
