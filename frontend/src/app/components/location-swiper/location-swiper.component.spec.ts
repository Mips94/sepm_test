import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocationSwiperComponent } from './location-swiper.component';

describe('LocationSwiperComponent', () => {
  let component: LocationSwiperComponent;
  let fixture: ComponentFixture<LocationSwiperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LocationSwiperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LocationSwiperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
