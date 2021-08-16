import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsaveisReadComponent } from './responsaveis-read.component';

describe('ResponsaveisReadComponent', () => {
  let component: ResponsaveisReadComponent;
  let fixture: ComponentFixture<ResponsaveisReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsaveisReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsaveisReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
