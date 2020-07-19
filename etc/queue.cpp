#include<iostream>
#define MAXVALUE 101 //큐 size

using namespace std;

template<class T> class Queue
{
public:
	int front;
	int rear;
	int size;
	T *values;

	Queue()
	{
		size = MAXVALUE;
		values = new T[size];
		front = 0;
		rear = 0;
	}
	~Queue()
	{
		delete[] values;
	}

	void push(T value)
	{
		if(!isFull())
		{
			values[rear] = value;
			rear = (rear + 1) % size;
		}
		else
			cout << "Queue is Full" << endl;
	}

	void pop()
	{
		if(!empty())
			front = (front + 1) % size;
		else
			cout << "Queue is Empty" << endl;
	}

	bool empty()
	{
		if(rear == front)
			return true;
		else 
			return false;
	}

	bool isFull()
	{
		if((rear + 1) % size == front) 
			return true;
		else 
			return false;
	}
};
/*
template<typename T>
ostream& operator <<(ostream &out, Queue<T> &q){
	T *temp = q.values;
	out << "front [ ";
	for(int i=q.front; i<q.rear; i++){
	    out << temp[i];
	    if(i < q.rear-1) out << " | ";
	}
	out << " ] rear" << endl;
    return out;
}
*/
template<typename T>
void print(Queue<T> &q) {
    T *temp = q.values;

    for(int i=q.front; i<q.rear; i++) {
        cout<<temp[i]<<" ";
    }
    cout<<endl;
}

int main()
{
	Queue<int> q;
	q.push(3);
	print(q);
	q.push(103);
	print(q);
	q.push(57);
    print(q);   
	q.pop();
    print(q);
	q.push(22);
	print(q);
	q.pop();
	print(q);
	q.pop();
	print(q);
	q.pop();
	print(q);
	q.pop();
	print(q);
}