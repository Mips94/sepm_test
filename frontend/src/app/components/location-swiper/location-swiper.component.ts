import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-location-swiper',
  templateUrl: './location-swiper.component.html',
  styleUrls: ['./location-swiper.component.scss']
})
export class LocationSwiperComponent implements OnInit {
  animationState = '';

  constructor() { }

  ngOnInit(): void {
  }

  startAnimation(state: string) {
    if(!this.animationState) {
      this.animationState = state;
    }
  }

  resetAnimationState() {
    this.animationState = '';
  }

}
