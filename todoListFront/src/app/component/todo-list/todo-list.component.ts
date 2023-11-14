import { Component } from '@angular/core';
import { TodoListService } from '../../service/todo-list.service';
import { Task } from '../../model/Task';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
})
export class TodoListComponent {
  tasks: Task[] = [];
  showForm: boolean = false;
  newTaskName?: string;

  constructor(private todoListService: TodoListService) {}

  ngOnInit(): void {
    this.todoListService.getTasks().subscribe((tasks) => (this.tasks = tasks));
  }

  onShowFormButtonClick(): void {
    this.showForm = true;
  }

  onAddTaskButtonClick(): void {
    this.showForm = false;
    this.todoListService
      .saveTask(new Task(this.newTaskName))
      .subscribe((response) => {
        window.location.reload();
        console.log('success', response);
      });
  }

  onTaskFinished(task: Task): void {
    this.todoListService.deleteTask(task).subscribe((response) => {
      window.location.reload();
      console.log('success', response);
    });
  }
}
