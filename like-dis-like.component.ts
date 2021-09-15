import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-like-dis-like',
  template: `
      <button (click)="likedClicked()" [ngClass]="likeClass" > Like | {{likeCount}} </button>
      <button (click)="dislikedClicked()" [ngClass]="disLikeClass"> DisLike | {{disLikeCount}} </button>
  `,
  styles: [`
      .like-button, .dislike-button {
        font-size: 1rem;
        padding: 5px 10px;
        color:green;
      }
      .liked, .disliked {
        font-weight: bold;
        color: blue;
      }
  `]
})
export class LikeDisLikeComponent implements OnInit {

  
likeClass: string="like-button";
disLikeClass: string="dislike-button";

likeCount: number =100; // 100 toggle with 101 and vice versa
disLikeCount: number=25; // 25 toggle with 26 and vice versa

likedClicked() {
  this.likeCount++;
  this.likeClass=" liked";
  console.log(this.likeClass);
}
dislikedClicked() {
  this.disLikeCount++;
}
constructor() { }

ngOnInit(): void {
}
}
/*

int likeCount=100
+ - 

onclick the text inside the button to be bold

   100        25
   |          |
   click    click 

   101        26
   |          |
   click    click 
   
   100        25
   |          |
   click    click 
   

*/