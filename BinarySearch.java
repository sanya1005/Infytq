public int binarySearch(int a[], int num)
    {
        if(num>a[a.length-1]||num<a[0])return -1;
        int start=0;
        int end =a.length-1;
        int mid=(start+end)/2;
        while(a[mid]!=num){
            if(num<mid){
                end=mid;
            }else{
                start=mid;
            }
            mid = (start+end)/2;
        }
        return mid;
    }
