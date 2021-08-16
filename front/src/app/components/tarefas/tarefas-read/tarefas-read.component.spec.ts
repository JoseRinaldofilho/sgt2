import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefasReadComponent } from './tarefas-read.component';

describe('TarefasReadComponent', () => {
  let component: TarefasReadComponent;
  let fixture: ComponentFixture<TarefasReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarefasReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TarefasReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
