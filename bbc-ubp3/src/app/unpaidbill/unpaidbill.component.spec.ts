import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnpaidbillComponent } from './unpaidbill.component';

describe('UnpaidbillComponent', () => {
  let component: UnpaidbillComponent;
  let fixture: ComponentFixture<UnpaidbillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnpaidbillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnpaidbillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
