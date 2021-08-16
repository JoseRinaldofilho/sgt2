import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefasCreateComponent } from './tarefas-create.component';

describe('TarefasCreateComponent', () => {
  let component: TarefasCreateComponent;
  let fixture: ComponentFixture<TarefasCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarefasCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TarefasCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
