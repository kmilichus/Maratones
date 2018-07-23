struct SegTree{
        int minVal;
        int start;
        int end;
        SegTree *left;
        SegTree *right;
        SegTree(int start,int end){
            this->start = start;
            this->end = end;
            if(start == end){
                left =  NULL;
                right = NULL;
            }
            else{
                int mid = (start+end)/2;
                left = new SegTree(start,mid);
                right = new SegTree(mid + 1,end);
            }
        }
        void set(int pos,int val){
            if(start == end && start == pos){
                this->minVal = val;
                return;
            }
            
            int mid = (start+end)/2;
            
            if( pos <= mid)
                left->set(pos,val);
            else
                right->set(pos,val);
           
            this->minVal = min(left->minVal,right->minVal); 
        }
        int getMin(int start,int end){
            if(this->start == start && this->end == end) return this->minVal;
            int mid = (this->start+this->end)/2;
            if(start <= mid && end <= mid) return left->getMin(start,end);
            if(start > mid && end > mid) return right->getMin(start,end);
            return min(left->getMin(start,mid),right->getMin(mid+1,end));
        }
};
